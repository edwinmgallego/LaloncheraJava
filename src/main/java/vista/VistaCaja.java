/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author cript
 */


import java.util.Scanner;

public class VistaCaja {
    private Scanner scanner;

    public VistaCaja() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int mostrarMenu() {
        System.out.println("\n--- LA LONCHERA .NET ---");
        System.out.println("1. Agregar Hamburguesa Clásica ($15.000)");
        System.out.println("2. Agregar Gaseosa ($5.000)");
        System.out.println("3. Ver Resumen del Pedido y Cobrar");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }
}