/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author saulm
 */
public class Pedido {

    protected List<Consumibles> listaConsumibles;

    public Pedido() {
        listaConsumibles = new LinkedList<>();
        listaConsumibles.add(new Consumibles(1, "Cocacola", 3, 2));
        listaConsumibles.add(new Consumibles(2, "Fanta Naranja", 5, 2));
        listaConsumibles.add(new Consumibles(3, "Cerveza", 5, 1.5));
        listaConsumibles.add(new Consumibles(4, "Cafe", 5, 1.1));
        listaConsumibles.add(new Consumibles(5, "Cerveza", 5, 1.5));
    }

    protected List<Consumibles> getListConsumibles() {
        return listaConsumibles;
    }
}
