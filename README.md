# 🍔 La Lonchera - Sistema de Pedidos MVC

Bienvenido al repositorio de **La Lonchera**, un proyecto educativo diseñado para demostrar la implementación práctica de la Programación Orientada a Objetos (POO) y el patrón de arquitectura Modelo-Vista-Controlador (MVC) en Java.

Este sistema simula la caja registradora de un restaurante de comidas rápidas, permitiendo tomar pedidos, calcular totales y guardar el registro de ventas en un archivo de texto.

## 🎯 Objetivos de Aprendizaje

Este proyecto integra los siguientes pilares de la programación en Java:

* **Arquitectura MVC:** Separación clara entre la lógica de negocio (Modelo), la interfaz de usuario (Vista) y la gestión de eventos (Controlador).
* **Clases Abstractas e Interfaces:** Uso de `abstract class Producto` como base y la interfaz `IEmpacable` para definir contratos de comportamiento.
* **Modificadores de Acceso:** Aplicación de encapsulamiento mediante `private`, `protected` y `public` para proteger la integridad de los datos.
* **Colecciones:** Manejo dinámico de objetos en memoria utilizando `List` y `ArrayList`.
* **Persistencia de Datos (I/O):** Lectura y escritura de archivos planos (`.txt`) utilizando `FileWriter` y `BufferedWriter` con bloques *Try-with-Resources*.

## 📂 Estructura del Proyecto

El código fuente está organizado en los siguientes paquetes dentro de NetBeans:

```text
src/
└── com/lonchera/
    ├── main/
    │   └── Main.java                # Punto de entrada de la aplicación
    ├── modelo/
    │   ├── IEmpacable.java          # Interfaz
    │   ├── Producto.java            # Clase abstracta base
    │   ├── Hamburguesa.java         # Clase concreta
    │   ├── Bebida.java              # Clase concreta
    │   ├── Pedido.java              # Gestor de la Colección de productos
    │   └── ArchivoServicio.java     # Lógica de persistencia (I/O)
    ├── vista/
    │   └── VistaCaja.java           # Interfaz simulada por consola
    └── controlador/
        └── CajaController.java      # Orquestador entre el Modelo y la Vista


## 🧩 Explicación Paso a Paso del Código (Diccionario de Clases)

A continuación, se detalla la responsabilidad de cada componente dentro de la arquitectura MVC para comprender el flujo de los datos y la lógica del sistema.

### 1. El Modelo (`com.lonchera.modelo`)
Esta capa contiene las reglas de negocio, la estructura de los datos y la lógica de almacenamiento. No interactúa directamente con el usuario.

* **`IEmpacable` (Interfaz)**
    * **Propósito:** Define un contrato de comportamiento. Cualquier clase que la implemente debe especificar cómo se empaca para llevar.
    * **`empacarParaLlevar()`:** Método sin cuerpo que obliga a las clases concretas a programar su propia lógica de empaque.

* **`Producto` (Clase Abstracta)**
    * **Propósito:** Es la plantilla base para todo lo que se venda en el restaurante. No se puede instanciar directamente.
    * **Atributos:** `nombre` y `precio` (marcados como `protected` para permitir la herencia).
    * **`Producto(String, double)`:** Constructor para inicializar los datos básicos.
    * **`getNombre()` / `getPrecio()`:** Métodos públicos (Getters) para leer los datos encapsulados.
    * **`preparar()`:** Método *abstracto*. Obliga a cada producto hijo a definir cómo se cocina o sirve.

* **`Hamburguesa` (Clase Concreta)**
    * **Propósito:** Representa un producto específico. Hereda de `Producto` e implementa `IEmpacable`.
    * **`preparar()`:** Sobrescribe (`@Override`) el método de la clase padre para imprimir el texto de "asando carne...".
    * **`empacarParaLlevar()`:** Cumple el contrato de la interfaz detallando que va en "caja de cartón".

* **`Bebida` (Clase Concreta)**
    * **Propósito:** Otro producto específico. Hereda de `Producto` pero *no* es empacable.
    * **Atributo:** `conHielo` (marcado como `private` demostrando encapsulamiento estricto).
    * **`preparar()`:** Sobrescribe el método padre para definir cómo se sirve según si tiene hielo o no.

* **`Pedido` (Gestor de Colecciones)**
    * **Propósito:** Agrupar temporalmente los productos que pide un cliente usando una lista dinámica.
    * **Atributo:** `listaProductos` (Un `ArrayList` de tipo `Producto`).
    * **`agregarProducto(Producto p)`:** Recibe cualquier objeto que herede de Producto (Polimorfismo) y lo añade a la lista.
    * **`calcularTotal()`:** Recorre la lista sumando los precios individuales y retorna el valor total.
    * **`getListaProductos()`:** Devuelve la colección completa.

* **`ArchivoServicio` (Servicio de Persistencia)**
    * **Propósito:** Manejar la entrada y salida (I/O) de datos hacia el disco duro.
    * **Atributo:** `nombreArchivo` (El nombre del archivo `.txt` destino).
    * **`guardarPedido(List<Producto>, double)`:** Recibe la colección de la venta y el total. Usa un bloque `try-with-resources` con `BufferedWriter` y `FileWriter` para escribir el recibo en el archivo de texto sin borrar el historial anterior (modo *append*).

### 2. La Vista (`com.lonchera.vista`)
Esta capa es la "cara" del programa. Su única responsabilidad es mostrar información y capturar lo que el usuario teclea. No hace cálculos.

* **`VistaCaja`**
    * **Propósito:** Simular la pantalla táctil o el monitor del cajero mediante la consola.
    * **Atributo:** `scanner` (Instancia de `java.util.Scanner` para leer el teclado).
    * **`mostrarMensaje(String)`:** Recibe un texto y lo imprime en pantalla. Evita tener `System.out.println` regados por todo el programa.
    * **`mostrarMenu()`:** Imprime las opciones numéricas del sistema, espera a que el usuario digite un número y lo retorna.

### 3. El Controlador (`com.lonchera.controlador`)
Es el cerebro de las operaciones. Comunica la Vista con el Modelo.

* **`CajaController`**
    * **Propósito:** Escuchar lo que el usuario pide en la vista, ejecutar acciones en el modelo y actualizar la vista con los resultados.
    * **Atributos:** Tiene instancias de `Pedido` (para guardar datos en memoria), `VistaCaja` (para hablar con el usuario) y `ArchivoServicio` (para guardar en el disco).
    * **`iniciarCaja()`:** Es un bucle (`do-while`) que mantiene el programa vivo, mostrando el menú repetidamente hasta que el usuario elija salir.
    * **`procesarOpcion(int)`:** Un bloque `switch` que evalúa qué número digitó el usuario. Aquí se instancian las hamburguesas o bebidas y se envían al modelo.
    * **`finalizarYCobrar()`:** Extrae la lista de productos del modelo, calcula el total, le dice a la vista que imprima el resumen, le ordena al servicio de archivos que guarde el `.txt`, y finalmente vacía la colección para recibir a un nuevo cliente.

### 4. El Punto de Entrada (`com.lonchera.main`)

* **`Main`**
    * **Propósito:** Es donde arranca el programa.
    * **`main(String[] args)`:** El método de ejecución principal de Java. Aquí se instancian las tres partes del MVC (Modelo, Vista, Controlador), se "conectan" pasándolas por parámetro al constructor del controlador, y se da la orden de `controlador.iniciarCaja()` para encender el sistema.
