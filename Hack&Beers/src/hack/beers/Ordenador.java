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
public class Ordenador {
    private int ID;
    private String procesador;
    private String placaBase;
    private String grafica;
    private String RAM;
    private String discoDuro;
    private String fuenteAlimentacion;
    private LinkedList<Programas> listaProgramas;

    public Ordenador(int ID, String procesador, String placaBase, String grafica, String RAM, String discoDuro, String fuenteAlimentacion) {
        this.ID = ID;
        this.procesador = procesador;
        this.placaBase = placaBase;
        this.grafica = grafica;
        this.RAM = RAM;
        this.discoDuro = discoDuro;
        this.fuenteAlimentacion = fuenteAlimentacion;
        listaProgramas=new LinkedList();
    }
    
    
}
