/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.conexion;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import hack.beers.Administrador;
import hack.beers.Conexion;
import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import hack.beers.Pedidos.Pedido;
import hack.beers.Usuario;
import hack.beers.vista.AdministradorV;
import hack.beers.vista.ClienteV;
import hack.beers.vista.ClienteVIP;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Instant.now;
import javax.swing.JOptionPane;
import ventasbd.dao.exception.ErrorConexionBD;

public class DAOHackBeer {

    static DAOHackBeer instancia = null;

    Usuario u = null;
    private boolean primerLog;

    //java.util.Date fecha = new Date();
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
                primerLog = rs.getBoolean(6);

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
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                    "SELECT * FROM administradores WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'"
            );
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
//ZOPOTAMADRE

    public void añadirConexion(Usuario u) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "INSERT INTO conexiones (dni, idOrdenador) VALUES('" + u.getDNI() + "','" + u.getIdOrdenador() + "')"
        );

    }

    public Usuario buscarConexionesUsuario(String DNI) throws SQLException, ErrorConexionBD {
        String dni;
        String nombre;
        String apellidos;
        String contraseñaU;
        int vip;
        boolean si = false;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "SELECT * FROM usuarios WHERE dni='" + DNI + "'"
        );

        while (rs.next()) {

            dni = rs.getString(1);
            nombre = rs.getString(2);
            apellidos = rs.getString(3);
            contraseñaU = rs.getString(4);
            vip = rs.getInt(5);
            u = new Usuario(nombre, apellidos, dni, contraseñaU, vip);
            si = true;
        }

        ResultSet rs1 = ConexionBD.instancia().getStatement().executeQuery(
                "Select * from conexiones where dni='" + DNI + "'"
        );

        while (rs1.next()) {
            Conexion c = new Conexion(rs1.getString(1), rs1.getInt(2), rs1.getString(3));
            System.out.println("conexion creada");
            u.añadirConexion(c);
        }

        if (si == false) {
            u = new Usuario("null", "null", DNI, "null", 0);
        }
        return u;
    }
//ZOPOTAMADRE

    public void annadirUsuario(Usuario u) throws SQLException {
        try {
            ConexionBD.instancia().getStatement().execute(
                    "Insert into usuarios values ('" + u.getDNI() + "', '" + u.getNombre() + "', '" + u.getApellidos() + "', '" + u.getContraseña() + "', " + u.getVIP() + ", 0)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
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
        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            u.annadirPedido(p);
        }
    }

    public void verTodosPedidos() {

    }

    public int pedirIdConsumible(String nombreConsumible) throws SQLException {
        int idConsumible = 0;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT idConsumible FROM consumibles WHERE Nombre ='" + nombreConsumible + "'");
        while (rs.next()) {
            idConsumible = rs.getInt(1);
        }
        return idConsumible;
    }

    public void eliminarUsuario(Usuario u) throws SQLException {
        ConexionBD.instancia().getStatement().execute(
                "delete from usuarios where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from conexiones where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from pedidos where dni='" + u.getDNI() + "'"
        );
        ConexionBD.instancia().getStatement().execute(
                "delete from almacenamiento where dni='" + u.getDNI() + "'"
        );

    }

    public void actualizarVip(Usuario u, int vip) throws SQLException {
        ConexionBD.instancia().getStatement().executeUpdate(
                "UPDATE usuarios SET vip=" + vip + " WHERE dni='" + u.getDNI() + "'"
        );
    }

    public void actualizarTablaPedidos(Administrador admin) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where realizado=0"
        );
        //admin.vaciarLista();
        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            admin.añadirPedido(p);
        }
    }

    public void actualizarTablaPedidosU(Usuario u) throws SQLException {
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery(
                "select * from pedidos where dni='" + u.getDNI() + "' AND realizado=0"
        );
        //admin.vaciarLista();
        while (rs.next()) {
            Pedido p = new Pedido(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getBoolean(6));
            u.añadirPedido(p);
        }
    }

    public boolean isPrimerLog() {
        return primerLog;
    }

    public void cambiarContraseña(String dni, String contraseña) throws SQLException {
        ConexionBD.instancia().getStatement().execute("UPDATE `usuarios` SET `Contraseña`='" + contraseña + "',`primerLog`=true WHERE dni='" + dni + "'");
    }

    public void confirmarPedido(int cantidad, int id, String dni) throws SQLException {
        int cantidadNueva = 0;
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT cantidad FROM pedidos WHERE idConsumible=" + id);
        while (rs.next()) {
            cantidadNueva = rs.getInt(1) - cantidad;
        }
        ConexionBD.instancia().getStatement().executeUpdate("UPDATE consumibles SET Cantidad="+cantidadNueva+" where idConsumible=" + id);
        ConexionBD.instancia().getStatement().execute("");
    }
}
