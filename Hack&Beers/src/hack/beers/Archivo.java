/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

import java.util.Date;

/**
 *
 * @author alxayu97
 */
public class Archivo {
    private String nombre;
    private Date fecha;
    private String propietario;

    public Archivo(String nombre, String propietario) {
        this.nombre = nombre;
        fecha = fechaSistema();
        this.propietario = propietario;
    }
    
    public Date fechaSistema(){
        java.util.Date fechaActual = new java.util.Date();
        return fechaActual;
    }
    
    public String ToString(){
         return this.nombre+" "+this.propietario+" "+this.fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getPropietario() {
        return propietario;
    }
    
    
    
}
