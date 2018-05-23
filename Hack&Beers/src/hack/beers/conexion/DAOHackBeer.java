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
import hack.beers.vista.annadirConsumible;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ventasbd.dao.exception.ErrorConexionBD;

public class DAOHackBeer {

    static DAOHackBeer instancia = null;
    Usuario u;

    //VAYA COJONAZOS 
    /*
    String dni;
    String nombre;
    String apellidos;
    String contraseñaU;
    int vip;
     */
    ///////////////
    
    public static DAOHackBeer instancia() {
        if (instancia == null) {
            instancia = new DAOHackBeer();
        }
        return instancia;
    }

    public void annadirConsumibles(Consumible c) throws SQLException, ErrorConexionBD {
        
        ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("select * from consumibles where idConsumible="+c.getId());
        
        if (rs.next()){
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
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM usuarios WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'");
            while (rs.next()) {
                dni = rs.getString(1);
                nombre = rs.getString(2);
                apellidos = rs.getString(3);
                contraseñaU = rs.getString(4);
                vip = rs.getInt(5);

                u = new Usuario(nombre, apellidos, dni, contraseñaU, vip);

                if (usuario.equals(dni) && contraseña.equals(contraseñaU)) {
                    JOptionPane.showMessageDialog(null, "Bienvenido: " + nombre + " " + apellidos);
                    if (vip == 1) {
                        ClienteVIP cliNuV = new ClienteVIP();
                        cliNuV.setVisible(true);
                    } else {
                        ClienteV cliNu = new ClienteV();
                        cliNu.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrectos");
                    contador++;
                }
            }
            if (contador == 1) {
                rs = ConexionBD.instancia().getStatement().executeQuery("SELECT * FROM administradores WHERE dni='" + usuario + "' AND contraseña='" + contraseña + "'");
                while (rs.next()) {
                    dni = rs.getString(1);
                    nombre = rs.getString(2);
                    apellidos = rs.getString(3);
                    contraseñaU = rs.getString(4);
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

    /*
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
     */
    public Usuario verDatosUsuario() throws SQLException {
        return u;
    }

}
