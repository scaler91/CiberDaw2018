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

/**
 *
 * @author alxayu97
 */
public class Administrador extends Persona{
    private LinkedList registroConexiones;
    
    //CONSTRUCTOR
    public Administrador(String nombre, String apellidos, String DNI, String contraseña) {
        super(nombre, apellidos, DNI, contraseña);
        registroConexiones=new LinkedList();
    }
    
    //MÉTODOS
    
    //Método para dar de alta a un usuario
    public void altaUsuarioBD(String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, boolean VIPUsuario) throws SQLException{
        ResultSet crearUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "insert into usuarios values ('"+DNIUsuario+"', '"+nombreUsuario+"', '"+apellidosUsuario+"', '"+contraseñaUsuario+"', '"+VIPUsuario+"')");
    }
    
    //Método para dar de baja a un usuario
    public void bajaUsuarioBD(String DNIUsuario) throws SQLException{
        ResultSet eliminarUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "delete from usuarios where dni = '"+DNIUsuario+"'");
    }
    
    //Método para modificar un usuario
    public void modificarUsuarioBD(String usuarioDNI, String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, String VIPUsuario) throws SQLException{
        ResultSet seleccionarUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "select * from usuarios where dni = "+usuarioDNI);
        if(DNIUsuario!=null){
            ResultSet cambiarDNI = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET dni="+DNIUsuario+" WHERE dni = "+usuarioDNI);
        }
        if(nombreUsuario!=null){
            ResultSet cambiarNombre = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET Nombre="+nombreUsuario+" WHERE dni = "+usuarioDNI);
        }
        if(apellidosUsuario!=null){
            ResultSet cambiarApellidos = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET Apellidos="+apellidosUsuario+" WHERE dni = "+usuarioDNI);
        }
        if(contraseñaUsuario!=null){
            ResultSet cambiarContraseña = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET Contraseña="+contraseñaUsuario+" WHERE dni = "+usuarioDNI);
        }
        if(nombreUsuario!=null){
            ResultSet cambiarNombre = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET Nombre="+nombreUsuario+" WHERE dni = "+usuarioDNI);
        }
        if(VIPUsuario!=null){
            ResultSet cambiarVIP = ConexionBD.instancia().getStatement().executeQuery(
            "UPDATE usuarios SET vip="+VIPUsuario+" WHERE dni = "+usuarioDNI);
        }
    }
    
    //Método para buscar un usuario
    public void consultarUsuarioBD(String usuarioDNI) throws SQLException{
        ResultSet seleccionarUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "select * from usuarios where dni = "+usuarioDNI);
    }
    
    public void altaOrdenadorBD(){
        
    }
    
    public void bajaOrdenadorBD(){
        
    }
    
    public void modificarOrdenadorBD(){
        
    }
    
    public void consultarOrdenadorBD(){
        
    }
    
    //Método para ver todos los archivos que son propiedad del usuario
    public void verArchivos(){
        
    }
    
    //Método para borrar los archivos que se quiera (SOLO si son de su propiedad)
    public void borrarArchivo(){
        
    }
    
    
    
}
