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

    }

    public void annadirLista() throws SQLException {
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

    public String[][] getStock() {
        //OJO con size al agregar campos nuevos.
        String[][] arrayConsumibles = new String[listaConsumibles.size()][4];
        for (int i = 0; i < listaConsumibles.size(); i++) {
            Consumible esteConsumible = (Consumible) listaConsumibles.get(i);
            arrayConsumibles[i][0] = "" + esteConsumible.getId();
            arrayConsumibles[i][1] = esteConsumible.getNombre();
            arrayConsumibles[i][2] = "" + esteConsumible.getCantidad();
            arrayConsumibles[i][3] = esteConsumible.getPrecio() + " €";
        }
        return arrayConsumibles;
    }

}
