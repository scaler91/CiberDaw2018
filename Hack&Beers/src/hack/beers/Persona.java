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
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import ventasbd.dao.exception.ErrorConexionBD;

/**
 *
 * @author alxayu97
 */
public abstract class Persona {
    String DNI;
    private String nombre;
    private String apellidos;
    String contraseña;

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
    public boolean conectarse(String usuario, String contraseña) throws ErrorConexionBD, SQLException{
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
    public void ejecutarPrograma() throws SQLException{
        //Lista a mostrar de programas
        LinkedList<Programa> programa= new LinkedList<>();
        Programa p;
        ResultSet misProgramas = ConexionBD.instancia().getStatement().executeQuery(
            "select * from programas");
        //Pasar la consulta SQL a LinkedList
        while(misProgramas.next()){
            String nombre = misProgramas.getString("nombre");
            p = new Programa(nombre);
            programa.add(p);
        }
        //Iterador para la lista de programas
        Iterator<Programa> ep = programa.iterator();
        while(ep.hasNext()) {
        ep.next().getNombre();
        }
    }
    
    
    //Método para desconectar la sesión actual del sistema
    public boolean desconectarse(){
        boolean conexion=false;
        ConexionBD.desconectar();
        return conexion;
    }
    
    //Método para ver todos los archivos que son propiedad del usuario
    public void verArchivos() throws SQLException{
        //Lista a mostrar al usuario con sus archivos
        LinkedList<Archivo> archivosPropios= new LinkedList<>();
        Archivo a;
        ResultSet misArchivos = ConexionBD.instancia().getStatement().executeQuery(
            "select * from almacenamiento where dni = '"+DNI+"'");
        //Pasar la consulta SQL a LinkedList
        while(misArchivos.next()){
            String dniDB = misArchivos.getString("dni");
            String nombreArchivo = misArchivos.getString("nombre");
            a = new Archivo(nombreArchivo, dniDB);
            archivosPropios.add(a);
        }
        //Iterador para la lista de archivos
        Iterator<Archivo> ia = archivosPropios.iterator();
        while(ia.hasNext()) {
        ia.next().getNombre();
        ia.next().getFecha();
        ia.next().getPropietario();
        }
    }
    
    //Método para borrar los archivos que se quiera (SOLO si son de su propiedad)
    public void borrarArchivo() throws SQLException{
        String nombreArchivo;
        //Visualiza la lista de archivos que tiene el usuario
        verArchivos();
        System.out.println("¿Qué archivo deseas eliminar?");
        Scanner entrada = new Scanner(System.in);
        nombreArchivo = entrada.next();
        //Elimina el archivo con el nombre dado
        ResultSet eliminarArchivo = ConexionBD.instancia().getStatement().executeQuery(
            "delete from almacenamiento where NombreArchivo = '"+nombreArchivo+"'");
        System.out.println("¡¡Hecho!!");
        //Visualiza los archivos restantes
        verArchivos();
    }
    

}
