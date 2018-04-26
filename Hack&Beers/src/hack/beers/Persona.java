/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

/**
 *
 * @author alxayu97
 */
public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String DNI;
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
    private boolean conectarse(){
        boolean conexion=false;
        return conexion;
    }
    
    //Método para que un usuario ejecute un programa en el sistema
    private void ejecutarPrograma(){
        
    }
    
    //Método para desconectar la sesión actual del sistema
    private boolean desconectarse(){
        boolean conexion=true;
        return conexion;
    }
    

}
