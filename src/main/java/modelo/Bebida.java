/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cript
 */


// CLASE CONCRETA 2
public class Bebida extends Producto {

    private boolean conHielo; // Modificador private, encapsulamiento estricto

    public Bebida(String nombre, double precio, boolean conHielo) {
        super(nombre, precio);
        this.conHielo = conHielo;
    }

    @Override
    public String preparar() {
        String hieloStr = conHielo ? " con hielo" : " sin hielo";
        return "Sirviendo " + nombre + hieloStr + " en el vaso.";
    }
}