/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.beers;

/**
 *
 * @author Alumno
 */
public class Conexion {
    
    private String DNI;
    private int idOrdenador;
    private String fecha;

    public Conexion(String DNI, int idOrdenador, String fecha) {
        this.DNI = DNI;
        this.idOrdenador = idOrdenador;
        this.fecha = fecha;
    }

    public String getDNI() {
        return DNI;
    }

    public int getIdOrdenador() {
        return idOrdenador;
    }
    
    public String obtenerIdOrdenador(){
        return Integer.toString(idOrdenador);
    }

    public String getFecha() {
        return fecha;
    }
    
}
