/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import hack.beers.conexion.ConexionBD;
import java.sql.SQLException;
import java.util.LinkedList;
import ventasbd.dao.exception.ErrorConexionBD;

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

 

    //MÉTODOS
    
    public void crearPedido(int id, int cantidad) throws SQLException{
        ConexionBD.instancia().getStatement().execute(
                "insert into pedidos values ('" + getDNI() + "', '" + mesa + "', '" + id + "', '" + cantidad + "')");
    }
    
    public void ponerQueja(){
        
    }

    //Método para ver todos los archivos que son propiedad del usuario
    public void verArchivos(){
        if(VIP==false){
            System.out.println("Lo sentimos, esta función solo está reservada a usuarios VIP");
        } else {

        }
    }

    //Método para borrar los archivos que se quiera (SOLO si son de su propiedad)
    public void borrarArchivo(){
        if(VIP==false){
            System.out.println("Lo sentimos, esta función solo está reservada a usuarios VIP");
        } else {

        }
    }
   public boolean conectarse(String usuario, String contraseña) throws ErrorConexionBD, SQLException{
       super.conectarse(usuario, contraseña);
       return ;
   }

}
