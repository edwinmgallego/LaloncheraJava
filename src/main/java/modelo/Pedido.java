/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cript
 */


import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // COLECCIÓN: ArrayList dinámico que usa polimorfismo (guarda cualquier 'Producto')
    private List<Producto> listaProductos;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : listaProductos) {
            total += p.getPrecio();
        }
        return total;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
