/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.conexion;

import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import hack.beers.Usuario;
import hack.beers.vista.AdministradorV;
import hack.beers.vista.ClienteV;
import hack.beers.vista.ClienteVIP;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ventasbd.dao.exception.ErrorConexionBD;

public class DAOHackBeer {

    static DAOHackBeer instancia = null;
    String dni;
    String nombre;
    String apellidos;
    String contraseñaU;
    int vip;

    public static DAOHackBeer instancia() {
        if (instancia == null) {
            instancia = new DAOHackBeer();
        }
        return instancia;
    }

    public void annadirConsumible(Consumible c) throws SQLException {
        ConexionBD.instancia().getStatement().execute("INSERT INTO `consumibles`(`idConsumible`, `Nombre`, `Precio`, `Cantidad`) VALUES  (" + c.getId() + ", '" + c.getNombre() + "', " + c.getPrecio() + ", " + c.getCantidad() + ")");
    }

    public void verConsumible(Inventario i) throws SQLException {
        Consumible c = null;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM `consumibles`");

        while (rs.next()) {
            c = new Consumible(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
            i.annadirConsumible(c);
        }
    }

    /**
     *
     * @param usuario
     * @param contraseña
     * @throws SQLException
     * @throws ErrorConexionBD
     */
    public void pedirUsuarios(String usuario, String contraseña) throws SQLException, ErrorConexionBD {
        int contador = 0;
        if (contador == 0) {
            ResultSet rsu = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM `usuarios`");
            while (rsu.next()) {
                dni = rsu.getString(1);
                nombre = rsu.getString(2);
                apellidos = rsu.getString(3);
                contraseñaU = rsu.getString(4);
                vip = rsu.getInt(5);
                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    //JOptionPane.showMessageDialog(this, "Bienvenido: " + nombre + " " + apellidos);
                    if (vip == 1) {
                        ClienteVIP cliNuV = new ClienteVIP();
                        cliNuV.setVisible(true);
                    } else {
                        ClienteV cliNu = new ClienteV();
                        cliNu.setVisible(true);
                    }
                } else {
                    // JOptionPane.showMessageDialog(this, "Contraseña o usuario incorrectos");
                    contador++;
                }
            }
            if (contador == 1) {
                ResultSet rsa = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM `administradores`");
                while (rsa.next()) {
                    dni = rsa.getString(1);
                    nombre = rsa.getString(2);
                    apellidos = rsa.getString(3);
                     contraseñaU = rsa.getString(4);
                    if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                        AdministradorV adm = new AdministradorV();
                        adm.setVisible(true);
                    } else {
                        contador--;
                    }
                }
            }
        }
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public String getContraseña() {
        return contraseñaU;
    }

    public int getVip() {
        return vip;
    }

}
