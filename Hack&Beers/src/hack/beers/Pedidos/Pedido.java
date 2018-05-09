/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers.Pedidos;
import java.util.*;

/**
 *
 * @author saulm
 */
public class Pedido {
    double precioTotal;
    String nombre;
    int mesa;
    int cantidad;
    int id;
    double precio;
    protected List<Consumibles> pedido;
    


    public Pedido(int mesa, int cantidad, double precio, int id, String nombre) {
        this.mesa=mesa;
        this.nombre=nombre;
        this.id=id;
        this.cantidad=cantidad;
        this.precio=precio;
        
        pedido.add(new Consumibles(id,nombre, cantidad, precio));
        
        

    }
    public void calcularPrecio(){
        precioTotal=0;
        Iterator <Consumibles> it=pedido.iterator();
        while(it.hasNext()){
           precioTotal=precioTotal+(precio*cantidad); 
            
        }
        
        
    }
   
}
