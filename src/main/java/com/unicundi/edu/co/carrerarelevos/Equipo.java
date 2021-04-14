/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.edu.co.carrerarelevos;

import java.util.List;

/**
 *
 * @author dparr
 */
public class Equipo extends Thread {
    
    private List<Corredor> equipo;

    public Equipo(List<Corredor> equipo) {
        this.equipo = equipo;
    }
    
    @Override
    public void run() {
        
    }
    
    
}
