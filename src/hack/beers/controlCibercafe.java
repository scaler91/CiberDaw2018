/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.Pedidos.Consumible;
import hack.beers.Pedidos.Inventario;
import hack.beers.Pedidos.Pedido;
import hack.beers.conexion.ConexionBD;
import hack.beers.conexion.DAOHackBeer;
import java.sql.SQLException;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author Alumno
 */
public class controlCibercafe {

    public controlCibercafe() throws ErrorConexionBD {
        ConexionBD.crearConexion();
    }

    public void annadirConsumibles(Consumible c) throws SQLException, ErrorConexionBD {
        DAOHackBeer.instancia().annadirConsumibles(c);
    }

    public void verConsumible(Inventario i) throws SQLException {
        DAOHackBeer.instancia().verConsumible(i);
    }

//    public void verPedidos(){
//        DAOHackBeer.instancia().verPedidos();
//    }
    public void verUsuarios(String usuario, String contraseña) throws SQLException, ErrorConexionBD {
        DAOHackBeer.instancia().pedirUsuarios(usuario, contraseña);
    }

    public Usuario verConexionesUsuario(String DNI) throws SQLException, ErrorConexionBD {
        return DAOHackBeer.instancia().buscarConexionesUsuario(DNI);

    }

    public Usuario verDatosUsuario() throws SQLException {
        return DAOHackBeer.instancia().verDatosUsuario();
    }

    public Administrador verDatosAdministrador() {
        return DAOHackBeer.instancia().verDatosAdministrador();
    }
    
    public void annadirUsuario(Usuario u) throws SQLException{
        DAOHackBeer.instancia().annadirUsuario(u);
    }

    public String getUsuario(Usuario u) {
        String usuario = u.getNombre();
        return usuario;
    }

    /*
    public static String getNombre() throws SQLException{
        return DAOHackBeer.instancia().getNombre();
    }
    public static String getApellido() throws SQLException{
        return DAOHackBeer.instancia().getApellido();
    }
    public static String getDNI() throws SQLException{
        return DAOHackBeer.instancia().getDni();
    }
    public static String getContraseña() throws SQLException{
        return DAOHackBeer.instancia().getContraseña();
    }
    public static int getVip() throws SQLException{
        return DAOHackBeer.instancia().getVip();
    }
     */
    public void annadirPedido(Pedido p) throws SQLException {
        DAOHackBeer.instancia().annadirPedido(p);
    }

    public int pedirIdConsumible(String nombreConsumible) throws SQLException {
        return DAOHackBeer.instancia().pedirIdConsumible(nombreConsumible);
    }
    
}