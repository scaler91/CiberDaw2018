/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;

import hack.beers.conexion.DAOHackBeer;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Alumno
 */
public class Inventario {

    protected List<Consumible> listaConsumibles;

    public Inventario() throws SQLException {
        listaConsumibles = new LinkedList<>();
        DAOHackBeer.instancia().verConsumible(this);
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
