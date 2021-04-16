/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unicundi.edu.co.carrerarelevos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de inicializar los corredores "hilos" de cada equipo,
 * simulando una carrera de relevos.
 *
 * @author Alejandro Cuaran
 * @author David Parrado
 * @version 1.0.0
 * @since Netbeans IDE 12.2, JDK 1.8.0_281
 */
public class Principal {

    /**
     * Constructor de la clase el cual inicaliza o hace llamado al método
     * que realiza la función de simular la carrera de relevos.
     */
    public Principal() {
        iniciarCarrera();
    }
    
    /**
     * Método que crea los equipos asignándole un nombre, ademas de crear los
     * corredores (hilos) los cuales se asignan a cada equipo, dándoles tanto
     * nombre como posición en la que se encuentra; finalmente se arranca
     * cada corredor.
     */
    public void iniciarCarrera() {
        Equipo azul =  new Equipo("Equipo1");
        Equipo rojo =  new Equipo("Equipo2");
        Equipo verde =  new Equipo("Equipo3");

        Corredor corredor1 = new Corredor(azul, "Juan", 0);
        Corredor corredor2 = new Corredor(azul, "David", 33);
        Corredor corredor3 = new Corredor(azul, "Camilo", 66);
        Corredor corredor4 = new Corredor(verde, "John", 0);
        Corredor corredor5 = new Corredor(verde, "Johans", 33);
        Corredor corredor6 = new Corredor(verde, "Sebastian", 66);
        Corredor corredor7 = new Corredor(rojo, "Marco", 0);
        Corredor corredor8 = new Corredor(rojo, "Nacho", 33);
        Corredor corredor9 = new Corredor(rojo, "Stuart", 66);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();
    }
    /**
     * Metodo que ejecuta un objeto de la clase Principal
     * @param args 
     */
    public static void main(String[] args) {
        new Principal();
    }
}
