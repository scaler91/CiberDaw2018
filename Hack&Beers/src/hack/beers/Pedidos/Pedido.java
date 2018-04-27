/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
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
        listaConsumibles.add(new Consumibles("Cocacola", 3, 2));
        listaConsumibles.add(new Consumibles("Fanta Naranja", 5, 2));
        listaConsumibles.add(new Consumibles("Cerveza", 5, 1.5));
        listaConsumibles.add(new Consumibles("Cafe", 5, 1.1));
        listaConsumibles.add(new Consumibles("Cerveza", 5, 1.5));
    }

    protected List<Consumibles> getListConsumibles() {
        return listaConsumibles;
    }
}
