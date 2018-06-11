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

    public void verUsuarios(String usuario, String contraseña) throws SQLException, ErrorConexionBD {
        DAOHackBeer.instancia().pedirUsuarios(usuario, contraseña);
    }

    public Usuario verConexionesUsuario(String DNI) throws SQLException, ErrorConexionBD {
        return DAOHackBeer.instancia().buscarConexionesUsuario(DNI);
    }

    public void añadirConexion(Usuario u) throws SQLException {
        DAOHackBeer.instancia().añadirConexion(u);
    }

    public Usuario verDatosUsuario() throws SQLException {
        return DAOHackBeer.instancia().verDatosUsuario();
    }

    public Administrador verDatosAdministrador() {
        return DAOHackBeer.instancia().verDatosAdministrador();
    }

    //ZOPOTAMADRE
    public void annadirUsuario(Usuario u) throws SQLException {
        DAOHackBeer.instancia().annadirUsuario(u);
    }

    public String getUsuario(Usuario u) {
        String usuario = u.getNombre();
        return usuario;
    }

    public void annadirPedido(Pedido p) throws SQLException {
        DAOHackBeer.instancia().annadirPedido(p);
    }

    public int pedirIdConsumible(String nombreConsumible) throws SQLException {
        return DAOHackBeer.instancia().pedirIdConsumible(nombreConsumible);
    }

    public void eliminarUsuario(Usuario u) throws SQLException {
        DAOHackBeer.instancia().eliminarUsuario(u);
    }

    public void actualizarVip(Usuario u, int vip) throws SQLException {
        DAOHackBeer.instancia().actualizarVip(u, vip);
    }

    public void actualizarTablaPedidos(Administrador admin) throws SQLException {
        DAOHackBeer.instancia().actualizarTablaPedidos(admin);
    }
    public void actualizarTablaPedidosU(Usuario u) throws SQLException {
        DAOHackBeer.instancia().actualizarTablaPedidosU(u);
    }

    public boolean isPrimerLog() {
        return DAOHackBeer.instancia().isPrimerLog();
    }

    public void cambiarContraseña(String dni, String contraseña) throws SQLException {
        DAOHackBeer.instancia().cambiarContraseña(dni, contraseña);
    }
}
