/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.conexion.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author alxayu97
 */
public abstract class Persona {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String contraseña;

    //CONSTRUCTOR
    
    public Persona(String nombre, String apellidos, String DNI, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.contraseña = contraseña;
    }

    //GETS Y SETS
    
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    //MÉTODOS
    
    //Método para iniciar sesión en el sistema
    private boolean conectarse(String usuario, String contraseña) throws ErrorConexionBD, SQLException{
        boolean conexionCorrecta=false;
        ConexionBD.crearConexion();
        //Comprobar contraseña
        ResultSet validarContraseña = ConexionBD.instancia().getStatement().executeQuery(
            "select Contraseña from usuarios where Contraseña = '"+contraseña+"'");
        //Comprobar usuario
        ResultSet validarUsuario = ConexionBD.instancia().getStatement().executeQuery(
            "select dni from usuarios where dni = '"+usuario+"'"+"and Contraseña = '"+contraseña+"'");
        if(validarContraseña.toString()==contraseña&&validarUsuario.toString()==usuario){
            conexionCorrecta=true;
        }
        return conexionCorrecta;
    }
    
    //Método para que un usuario ejecute un programa en el sistema
    private void ejecutarPrograma(){
        
    }
    
    //Método para desconectar la sesión actual del sistema
    private void desconectarse(){
        ConexionBD.desconectar();
    }
    
    //Método para ver todos los archivos que son propiedad del usuario
    private void verArchivos(){
        
    }
    
    //Método para borrar los archivos que se quiera (SOLO si son de su propiedad)
    private void borrarArchivo(){
        
    }
    

}
