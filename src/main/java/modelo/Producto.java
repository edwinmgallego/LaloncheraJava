/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cript
 */


// CLASE ABSTRACTA: El molde general.
public abstract class Producto {
    // MODIFICADORES DE ACCESO: protected para permitir herencia
    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos públicos (API de la clase)
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Método abstracto: Las clases hijas DEBEN implementarlo
    public abstract String preparar();
}
