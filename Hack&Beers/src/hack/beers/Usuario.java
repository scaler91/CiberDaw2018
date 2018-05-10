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
import ventasbd.dao.exception.ErrorConexionBD;
import java.util.*;

/**
 *
 * @author alxayu97
 */
public class Usuario extends Persona {

    private boolean VIP;
    private LinkedList registroConexiones;
    
    public Usuario(String nombre, String apellidos, String DNI, String contraseña, boolean VIP) {
        super(nombre, apellidos, DNI, contraseña);
        this.VIP=VIP;

        registroConexiones=new LinkedList();
    }

    public boolean isVIP() {
        return VIP;
    }

    public LinkedList getRegistroConexiones() {
        return registroConexiones;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public void setRegistroConexiones(LinkedList registroConexiones) {
        this.registroConexiones = registroConexiones;
    }



    //MÉTODOS
    
    public void crearPedido(int id, int mesa, int cantidad) throws SQLException{
        ConexionBD.instancia().getStatement().execute(
                "insert into pedidos values ('" + getDNI() + "', '" + mesa + "', '" + id + "', '" + cantidad + "')");
    }
    
    public void ponerQueja(){
        
    }

    //Método para ver todos los archivos que son propiedad del usuario
    public void verArchivos() throws SQLException{
        if(VIP==false){
            System.out.println("Lo sentimos, esta función solo está reservada a usuarios VIP");
        } else {
            LinkedList<Archivo> archivosPropios = new LinkedList<>();
        Archivo a;
        ResultSet misArchivos = ConexionBD.instancia().getStatement().executeQuery(
                "select * from almacenamiento where dni = '" + DNI + "'");
        //Pasar la consulta SQL a LinkedList
        while (misArchivos.next()) {
            String dniDB = misArchivos.getString("dni");
            String nombreArchivo = misArchivos.getString("nombre");
            a = new Archivo(nombreArchivo, dniDB);
            archivosPropios.add(a);
        }
        //Iterador para la lista de archivos
        Iterator<Archivo> ia = archivosPropios.iterator();
        while (ia.hasNext()) {
            ia.next().getNombre();
            ia.next().getFecha();
            ia.next().getPropietario();
        }

        }
    }

    //Método para borrar los archivos que se quiera (SOLO si son de su propiedad)
    public void borrarArchivo() throws SQLException{
        if(VIP==false){
            System.out.println("Lo sentimos, esta función solo está reservada a usuarios VIP");
        } else {
            String nombreArchivo;
        //Visualiza la lista de archivos que tiene el usuario
        verArchivos();
        System.out.println("¿Qué archivo deseas eliminar?");
        Scanner entrada = new Scanner(System.in);
        nombreArchivo = entrada.next();
        //Elimina el archivo con el nombre dado
        ResultSet eliminarArchivo = ConexionBD.instancia().getStatement().executeQuery(
                "delete from almacenamiento where NombreArchivo = '" + nombreArchivo + "'");
        System.out.println("¡¡Hecho!!");
        //Visualiza los archivos restantes
        verArchivos();

        }
    }
    
    @Override
   public boolean conectarse(String usuario, String contraseña) throws ErrorConexionBD, SQLException{
       //super.conectarse(String usuario, String contraseña);
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

}
