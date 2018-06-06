/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.conexion.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alxayu97
 */
public class Administrador extends Persona {

    private LinkedList registroConexiones;
    private List pedido;

    //CONSTRUCTOR
    public Administrador(String nombre, String apellidos, String DNI, String contraseña) {
        super(nombre, apellidos, DNI, contraseña);
        registroConexiones = new LinkedList();
        pedido = new LinkedList<>();
    }

    //MÉTODOS
    /**
     * Método para dar de alta a un usuario
     *
     * @param nombreUsuario
     * @param apellidosUsuario
     * @param DNIUsuario
     * @param contraseñaUsuario
     * @param VIPUsuario
     * @throws SQLException
     */
    public void altaUsuarioBD(String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, boolean VIPUsuario) throws SQLException {
        ResultSet crearUsuario = ConexionBD.instancia().getStatement().executeQuery(
                "insert into usuarios values ('" + DNIUsuario + "', '" + nombreUsuario + "', '" + apellidosUsuario + "', '" + contraseñaUsuario + "', '" + VIPUsuario + "')");
    }

    /**
     * Método para dar de baja a un usuario
     *
     * @param DNIUsuario
     * @throws SQLException
     */
    public void bajaUsuarioBD(String DNIUsuario) throws SQLException {
        ResultSet eliminarUsuario = ConexionBD.instancia().getStatement().executeQuery(
                "delete from usuarios where dni = '" + DNIUsuario + "'");
    }

    /**
     * Método para modificar un usuario
     *
     * @param usuarioDNI
     * @param nombreUsuario
     * @param apellidosUsuario
     * @param DNIUsuario
     * @param contraseñaUsuario
     * @param VIPUsuario
     * @throws SQLException
     */
    public void modificarUsuarioBD(String usuarioDNI, String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, String VIPUsuario) throws SQLException {
        ResultSet seleccionarUsuario = ConexionBD.instancia().getStatement().executeQuery(
                "select * from usuarios where dni = " + usuarioDNI);
        if (DNIUsuario != null) {
            ResultSet cambiarDNI = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET dni=" + DNIUsuario + " WHERE dni = " + usuarioDNI);
        }
        if (nombreUsuario != null) {
            ResultSet cambiarNombre = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET Nombre=" + nombreUsuario + " WHERE dni = " + usuarioDNI);
        }
        if (apellidosUsuario != null) {
            ResultSet cambiarApellidos = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET Apellidos=" + apellidosUsuario + " WHERE dni = " + usuarioDNI);
        }
        if (contraseñaUsuario != null) {
            ResultSet cambiarContraseña = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET Contraseña=" + contraseñaUsuario + " WHERE dni = " + usuarioDNI);
        }
        if (nombreUsuario != null) {
            ResultSet cambiarNombre = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET Nombre=" + nombreUsuario + " WHERE dni = " + usuarioDNI);
        }
        if (VIPUsuario != null) {
            ResultSet cambiarVIP = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE usuarios SET vip=" + VIPUsuario + " WHERE dni = " + usuarioDNI);
        }
    }

    /**
     * Método para buscar un usuario
     *
     * @param usuarioDNI
     * @throws SQLException
     */
    public void consultarUsuarioBD(String usuarioDNI) throws SQLException {
        ResultSet seleccionarUsuario = ConexionBD.instancia().getStatement().executeQuery(
                "select * from usuarios where dni = " + usuarioDNI);
    }

    /**
     * Método para dar de alta un ordenador
     *
     * @param ID
     * @param procesador
     * @param placaBase
     * @param grafica
     * @param RAM
     * @param discoDuro
     * @param fuenteAlimentacion
     * @throws SQLException
     */
    public void altaOrdenadorBD(int ID, String procesador, String placaBase, String grafica, String RAM, String discoDuro, String fuenteAlimentacion) throws SQLException {
        ResultSet crearOrdenador = ConexionBD.instancia().getStatement().executeQuery(
                "insert into ordenadores values ('" + ID + "', '" + procesador + "', '" + placaBase + "', '" + grafica + "', '" + RAM + "', '" + discoDuro + "', '" + fuenteAlimentacion + "')");
    }

    /**
     * Método para dar de baja un ordenador
     *
     * @param ID
     * @throws SQLException
     */
    public void bajaOrdenadorBD(int ID) throws SQLException {
        ResultSet eliminarOrdenador = ConexionBD.instancia().getStatement().executeQuery(
                "delete from ordenadores where IdOrdenador = '" + ID + "'");
    }

    /**
     * Método para modificar un ordenador
     *
     * @param IDOrdenador
     * @param ID
     * @param procesador
     * @param placaBase
     * @param grafica
     * @param RAM
     * @param discoDuro
     * @param fuenteAlimentacion
     * @throws SQLException
     */
    public void modificarOrdenadorBD(int IDOrdenador, String ID, String procesador, String placaBase, String grafica, String RAM, String discoDuro, String fuenteAlimentacion) throws SQLException {
        ResultSet seleccionarOrdenador = ConexionBD.instancia().getStatement().executeQuery(
                "select * from ordenadores where IdOrdenador = " + IDOrdenador);
        if (ID != null) {
            ResultSet cambiarID = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET IdOrdenadores=" + ID + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (procesador != null) {
            ResultSet cambiarProcesador = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET procesador=" + procesador + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (placaBase != null) {
            ResultSet cambiarPlaca = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET placaBase=" + placaBase + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (grafica != null) {
            ResultSet cambiarGrafica = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET grafica=" + grafica + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (RAM != null) {
            ResultSet cambiarRAM = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET ram=" + RAM + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (discoDuro != null) {
            ResultSet cambiarDisco = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET discoDuroGB=" + discoDuro + " WHERE IdOrdenadores = " + IDOrdenador);
        }
        if (fuenteAlimentacion != null) {
            ResultSet cambiarFuente = ConexionBD.instancia().getStatement().executeQuery(
                    "UPDATE ordenadores SET fuente=" + fuenteAlimentacion + " WHERE IdOrdenadores = " + IDOrdenador);
        }
    }

    /**
     * Método para consultar un ordenador
     *
     * @param ID
     * @throws SQLException
     */
    public void consultarOrdenadorBD(String ID) throws SQLException {
        ResultSet seleccionarOrdenador = ConexionBD.instancia().getStatement().executeQuery(
                "select * from ordenadores where IdOrdenadores = " + ID);
    }

//    @Override
//    public boolean conectarse(String usuario, String contraseña) throws ErrorConexionBD, SQLException{
//       boolean conexionCorrecta=false;
//        ConexionBD.crearConexion();
//        //Comprobar contraseña
//        ResultSet validarContraseña = ConexionBD.instancia().getStatement().executeQuery(
//            "select Contraseña from administradores where Contraseña = '"+contraseña+"'");
//        //Comprobar usuario
//        ResultSet validarAdmin = ConexionBD.instancia().getStatement().executeQuery(
//            "select dni from administradores where dni = '"+usuario+"'"+"and Contraseña = '"+contraseña+"'");
//        if(validarContraseña.toString()==contraseña&&validarAdmin.toString()==usuario){
//            conexionCorrecta=true;
//        }
//       return conexionCorrecta;
//   }
}
