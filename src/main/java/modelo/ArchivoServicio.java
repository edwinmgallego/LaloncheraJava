/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cript
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicio {
    private String nombreArchivo = "ventas_lonchera.txt";

    // Recibe una lista (Colección) de productos para guardarlos
    public void guardarPedido(List<Producto> productos, double total) {
        // try-with-resources: asegura que el archivo se cierre solo al terminar
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write("=== NUEVO PEDIDO ===");
            writer.newLine();
            
            for (Producto p : productos) {
                // Guardamos nombre y precio separados por un guion
                writer.write(p.getNombre() + " - $" + p.getPrecio());
                writer.newLine();
            }
            
            writer.write("TOTAL COBRADO: $" + total);
            writer.newLine();
            writer.write("----------------------------");
            writer.newLine();
            
            System.out.println("Archivo actualizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}