/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.conexion;

import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOHackBeer {

    static DAOHackBeer instancia = null;

    public static DAOHackBeer instancia() {
        if (instancia == null) {
            instancia = new DAOHackBeer();
        }
        return instancia;
    }

    public void annadirConsumible(Consumible c) throws SQLException {
        ConexionBD.instancia().getStatement().execute("insert into consumibles values (" + c.getId() + ", '" + c.getNombre() + "', " + c.getPrecio() + ", " + c.getCantidad() + ")");
    }

    public void verConsumible(Inventario i) throws SQLException {
        Consumible c = null;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("select * from consumibles");

        while (rs.next()) {
            c = new Consumible(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            i.annadirConsumible(c);
        }

    }

}
