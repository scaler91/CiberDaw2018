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
 * @author Alumno
 */
public class Inventario {

    protected List<Consumible> listaConsumibles;

    public Inventario() {
        listaConsumibles = new LinkedList<>();
    }

    public void annadirConsumible(Consumible c) {
        listaConsumibles.add(c);
    }

    public List getInventario() {
        return listaConsumibles;
    }

    public void deleteConsumibles(int i) {
        listaConsumibles.remove(i);
    }

}
