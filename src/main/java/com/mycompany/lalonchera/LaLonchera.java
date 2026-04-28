/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lalonchera;

/**
 *
 * @author cript
 */
import modelo.Pedido;
import vista.VistaCaja;
import controlador.CajaController;
public class LaLonchera {

    public static void main(String[] args) {
        System.out.println("La lonchera");
        // 1. Inicializamos el Modelo
        Pedido modelo = new Pedido();
        
        // 2. Inicializamos la Vista
        VistaCaja vista = new VistaCaja();
        
        // 3. Inicializamos el Controlador pasándole el Modelo y la Vista
        CajaController controlador = new CajaController(modelo, vista);
        
        // 4. Arrancamos la aplicación
        controlador.iniciarCaja();
    }
}
