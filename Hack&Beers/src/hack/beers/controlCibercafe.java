/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import hack.beers.conexion.DAOHackBeer;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class controlCibercafe {
    
    public void añadirConsumible(Consumible c) throws SQLException{
        DAOHackBeer.instancia().annadirConsumible(c);
    }
    
    public void verConsumible (Inventario i) throws SQLException{
        DAOHackBeer.instancia().verConsumible(i);
    }
}
