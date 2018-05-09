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
    
    public Administrador(String nombre, String apellidos, String DNI, String contraseña) {
        super(nombre, apellidos, DNI, contraseña);
        registroConexiones=new LinkedList();
    }
    
    public void altaUsuarioBD(String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, boolean VIPUsuario) throws SQLException{
        ResultSet crearUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "insert into usuarios values ('"+DNIUsuario+"', '"+nombreUsuario+"', '"+apellidosUsuario+"', '"+contraseñaUsuario+"', '"+VIPUsuario+"')");
    }
    
    public void bajaUsuarioBD(String DNIUsuario) throws SQLException{
        ResultSet eliminarUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "delete from usuarios where dni = '"+DNIUsuario+"'");
    }
    
    public void modificarUsuarioBD(String nombreUsuario, String apellidosUsuario, String DNIUsuario, String contraseñaUsuario, boolean VIPUsuario){
        
    }
    
    public void consultarUsuarioBD(){
        
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
