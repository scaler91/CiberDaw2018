/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.conexion;

import hack.beers.Administrador;
import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import hack.beers.Pedidos.Pedido;
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

    Usuario u;
    Administrador a;

    public static DAOHackBeer instancia() {
        if (instancia == null) {
            instancia = new DAOHackBeer();
        }
        return instancia;
    }

    public void annadirConsumibles(Consumible c) throws SQLException, ErrorConexionBD {

        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("select * from consumibles where idConsumible=" + c.getId());

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "El ID del Consumible introducido ya está siendo usado.");
        } else {
            ConexionBD.instancia().getStatement().execute(
                    "INSERT INTO consumibles VALUES (" + c.getId() + ", '" + c.getNombre() + "', " + c.getPrecio() + ", " + c.getCantidad() + ")"
            );
            JOptionPane.showMessageDialog(null, "Consumible introducido.");
        }
    }

    public void verConsumible(Inventario i) throws SQLException {
        Consumible c = null;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM consumibles");

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
        String dni = null;
        String nombre;
        String apellidos;
        String contraseñaU;
        int vip;

        int contador = 0;
        if (contador == 0) {
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "SELECT * FROM usuarios WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'"
            );

            while (rs.next()) {
                dni = rs.getString(1);
                nombre = rs.getString(2);
                apellidos = rs.getString(3);
                contraseñaU = rs.getString(4);
                vip = rs.getInt(5);

                u = new Usuario(nombre, apellidos, dni, contraseñaU, vip);
                contador++;
                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido: " + nombre + " " + apellidos);

                    if (vip == 1) {
                        ClienteVIP cliNuV = new ClienteVIP();
                        cliNuV.setVisible(true);
                    } else {
                        ClienteV cliNu = new ClienteV();
                        cliNu.setVisible(true);
                    }
                }
            }
            contador++;
        }
        if (contador == 1) {
            contador--;
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM administradores WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'");
            while (rs.next()) {

                dni = rs.getString(1);
                nombre = rs.getString(2);
                apellidos = rs.getString(3);
                contraseñaU = rs.getString(4);

                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    a = new Administrador(nombre, apellidos, dni, contraseñaU);
                    AdministradorV adm = new AdministradorV();
                    adm.setVisible(true);
                    contador++;
                }
            }
        }
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectos");
        }

    }

    public Usuario verDatosUsuario() throws SQLException {
        return u;
    }

    public Administrador verDatosAdministrador() {
        return a;
    }

//    public void verPedidos(String dni, Pedido p) throws SQLException {
//        Consumible c = null;
//        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM pedidos where dni = " + dni);
//        ResultSet rp = ConexionBD.instancia().getStatement().executeQuery("select * from consumibles where idConsumbible = "+ rs.getString(3));
//
//        while (rp.next()) {
//            c = new Consumible(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
//            p.annadirConsumible(c);
//        }
//    }
    public void annadirPedido(Pedido p) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "INSERT INTO `pedidos` VALUES ('" + p.getDni() + "'," + p.getOrdenador() + "," + p.getIdConsumible() + "," + p.getCantidad() + "," + p.getPrecio() + "," + p.isRealizado() + ")"
        );
    }

    public void verPedidosUsuario(String dni) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where dni='" + dni + "'"
        );
        while (rs.next()){
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            u.annadirPedido(p);
        }
    }

    public void verTodosPedidos() {

    }

}
