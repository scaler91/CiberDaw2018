/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;

import java.awt.List;
import java.util.LinkedList;

/**
 *
 * @author saulm
 */
public class Pedido {

    String dni;
    int ordenador;
    int idConsumible;
    int cantidad;
    boolean realizado;
    float precio;

    public Pedido(String dni, int ordenador, int idConsumible, int cantidad, float precio, boolean realizado) {

        this.dni = dni;
        this.ordenador = ordenador;
        this.idConsumible = idConsumible;
        this.cantidad = cantidad;
        this.realizado = realizado;
        this.precio = precio;
        
    }

    

    public String getDni() {
        return dni;
    }

    public int getOrdenador() {
        return ordenador;
    }

    public int getIdConsumible() {
        return idConsumible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public float getPrecio() {
        return precio;
    }

}
