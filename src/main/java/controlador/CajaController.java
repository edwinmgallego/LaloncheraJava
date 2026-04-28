/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author cript
 */


import modelo.*;




import vista.VistaCaja;

public class CajaController {
    private Pedido modeloPedido;
    private VistaCaja vista;
    private ArchivoServicio archivoServicio; // Nuevo componente

    public CajaController(Pedido modeloPedido, VistaCaja vista) {
        this.modeloPedido = modeloPedido;
        this.vista = vista;
        this.archivoServicio = new ArchivoServicio(); // Instanciamos el servicio
    }

    public void iniciarCaja() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                modeloPedido.agregarProducto(new Hamburguesa("Hamburguesa Clásica", 15000));
                vista.mostrarMensaje("✅ Hamburguesa agregada.");
                break;
            case 2:
                modeloPedido.agregarProducto(new Bebida("Gaseosa Cola", 5000, true));
                vista.mostrarMensaje("✅ Bebida agregada.");
                break;
            case 3:
                finalizarYCobrar();
                break;
            case 0:
                vista.mostrarMensaje("Saliendo del sistema...");
                break;
            default:
                vista.mostrarMensaje("Opción inválida.");
        }
    }

    private void finalizarYCobrar() {
        double total = modeloPedido.calcularTotal();
        
        // 1. Mostrar en la Vista
        vista.mostrarMensaje("\n--- RESUMEN FINAL ---");
        for (Producto p : modeloPedido.getListaProductos()) {
            vista.mostrarMensaje("- " + p.getNombre());
        }
        vista.mostrarMensaje("TOTAL: $" + total);

        // 2. Guardar en el Archivo (.txt) usando el servicio
        archivoServicio.guardarPedido(modeloPedido.getListaProductos(), total);
        
        vista.mostrarMensaje("¡Venta registrada en el sistema y en el archivo txt!");
        
        // Limpiamos el pedido actual para el siguiente cliente
        // Esto demuestra el manejo dinámico de la Colección
        modeloPedido.getListaProductos().clear(); 
    }
}