/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;
import java.util.*;

/**
 *
 * @author Alumno
 */
public class Inventario {
     protected List<Consumibles> listaConsumibles;
     
     public void annadirConsumibles(  ){
         
         
         listaConsumibles.add(new Consumibles("Cocacola", 3, 2));
            
         
         
         
         
     }
     public List getInventario() {
        return listaConsumibles;
     }
     public void deleteConsumibles(int i){
         listaConsumibles.remove(i);
     }
    
}
