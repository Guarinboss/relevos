/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unicundi.edu.co.carrerarelevos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cenef
 */
public class Principal {

    public Principal() {
        iniciarCarrera();
    }
    
    public void iniciarCarrera() {
        List<Corredor> equipo1 = new ArrayList<>();
        List<Corredor> equipo2 = new ArrayList<>();
        List<Corredor> equipo3 = new ArrayList<>();
        
        for (int i = 1; i <= 3; i++) {
            equipo1.add(new Corredor("Corredor " + i, "Rojo"));
            equipo2.add(new Corredor("Corredor " + i, "Azul"));
            equipo3.add(new Corredor("Corredor " + i, "Amarillo"));
        }
        
        Equipo e1 = new Equipo(equipo1);
        Equipo e2 = new Equipo(equipo2);
        Equipo e3 = new Equipo(equipo3);
        
        e1.start();
        e2.start();
        e3.start();
        
    }
    
    public static void main(String[] args) {
        new Principal();
    }
}
