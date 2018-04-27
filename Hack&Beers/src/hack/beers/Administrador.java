/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

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
    
    private void altaUsuarioBD(){
        
    }
    
    private void bajaUsuarioBD(){
        
    }
    
    private void modificarUsuarioBD(){
        
    }
    
    private void consultarUsuarioBD(){
        
    }
    
    private void altaOrdenadorBD(){
        
    }
    
    private void bajaOrdenadorBD(){
        
    }
    
    private void modificarOrdenadorBD(){
        
    }
    
    private void consultarOrdenadorBD(){
        
    }
    
    
    
}
