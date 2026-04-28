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
