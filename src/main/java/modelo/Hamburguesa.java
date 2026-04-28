/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cript
 */


// CLASE CONCRETA 1: Implementa la interfaz IEmpacable
public class Hamburguesa extends Producto implements IEmpacable {

    public Hamburguesa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public String preparar() {
        return "Asando carne, tostando pan y armando la " + nombre + ".";
    }

    @Override
    public String empacarParaLlevar() {
        return "Guardando la hamburguesa en caja de cartón.";
    }
}
