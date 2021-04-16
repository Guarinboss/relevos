/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.edu.co.carrerarelevos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de inicializar tanto el nombre del equipo como los puestos 
 * que ocupará cada corredor por equipo para así realizar la simulación de la 
 * carrera.
 *
 * @author Alejandro Cuaran
 * @author David Parrado
 * @version 1.0.0
 * @since Netbeans IDE 12.2, JDK 1.8.0_281
 */
public class Equipo {
   
   /**
    * Variable que indica el nombre del equipo.
    */
    private String nombreEquipo;
    
    /**
     * Variable que incida la posición para el primer corredor de cada equipo.
     */
    private int posicion1;
    
    /**
     * Variable que incida la posición para el segundo corredor de cada equipo.
     */
    private int posicion2;
    
    /**
     * Variable que incida la posición para el tercer corredor de cada equipo.
     */
    private int posicion3;
    
    /*
    * constructtor de el equipo donde se incicializa la 
      posición de cada jugador.
    */
        
    public Equipo(String nombreEqui) {
        this.nombreEquipo = nombreEqui;
        this.posicion1 = 0;
        this.posicion2 = 33;
        this.posicion3 = 66;
    }
    
    /*
    *metodo tipo synchronized String donde se imprimen los puestos
     por color.
    */
    public synchronized String imprimirPuesto() {
        String puesto = "";
        int contador = 0;
        puesto =  nombreEquipo;  
        
        for (int i = 0; i <= 100; i++) {
            if (i == posicion1) {
                puesto += "O";
            } else if (i == posicion2) {
                puesto += "D";
            } else if (i == posicion3) {
                puesto += "+";
            } else {
                puesto += "_";
            }
            //Runtime.getRuntime().exec("cls");
        } 
        return puesto;
    }
    
    /*
    * creación de getters y setters de cada variable.
    */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(int posicion1) {
        this.posicion1 = posicion1;
    }

    public int getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(int posicion2) {
        this.posicion2 = posicion2;
    }

    public int getPosicion3() {
        return posicion3;
    }

    public void setPosicion3(int posicion3) {
        this.posicion3 = posicion3;
    }
    
}
