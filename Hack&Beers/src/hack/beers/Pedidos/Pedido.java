/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;

import java.util.*;

/**
 *
 * @author saulm
 */
public class Pedido {

    double precioTotal;
    int ordenador;
    double precio;
    protected List<Consumibles> pedido;

    public Pedido(int ordenador) {
        this.ordenador = ordenador;
        pedido = new LinkedList<Consumibles>();

    }

    public void nuevoPedido(int id, String nombre, int cantidad, double precio) {
        pedido.add(new Consumibles(id, nombre, cantidad, precio));
    }

//    public void calcularPrecio(){
//        precioTotal=0;
//        Iterator <Consumibles> it=pedido.iterator();
//        while(it.hasNext()){
//           precioTotal=precioTotal+(precio*cantidad); 
//            
//        }
//        
//        
//    }
}
