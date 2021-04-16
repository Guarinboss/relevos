/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.edu.co.carrerarelevos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que extiende de Thread, encargada de procesar la lógica para simular
 * la carrera de relevos, esta simulará las acciones que tomarán los corredores
 * de cada equipo, como lo son: "correr", "esperar" y "mostrar".
 *
 * @author Alejandro Cuaran
 * @author David Parrado
 * @version 1.0.0
 * @since Netbeans IDE 12.2, JDK 1.8.0_281
 */
public class Corredor extends Thread {
    
    /**
     * Variable que indica el equipo del corredor.
     */
    private Equipo equipo;
     
    /**
     * Variable que indica la posición inicial del corredor.
     */
    private int posicionInicial;
    
    /**
     * Variable que indica la posición actual del corredor 1.
     */
    private String equipo1;
    
    /**
     * Variable que indica la posición actual del corredor 2.
     */
    private String equipo2;
    
    /**
     * Variable que indica la posición actual del corredor 3.
     */
    private String equipo3;

    /**
     * Constructor sobrecargado de la clase Corredor que recibe el equipo del
     * corredor, el nombre del equipo y la posición inicial del corredor 
     * asigado en la clase Principal.
     * 
     * @param equipo recibe como parámetro el equipo del corredor.
     * @param posicionInicial recibe como parámetro la posición inicial del 
     * corredor.
     */
    public Corredor(Equipo equipo, int posicionInicial) {
        this.equipo = equipo;
        this.posicionInicial = posicionInicial;
    }

    
    /**
     * Método que sobrescribe el método original "run" de la clase "Thread" el
     * cual correrá los métodos que inicializarán la simulación de la carrera.
     */
    @Override
    public void run() {
        if (getPosicionInicial() == 0) {
            arrancar1();
        } else {
            synchronized (getEquipo()) {
            try {
                getEquipo().wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (getPosicionInicial() == 33) {
            arrancar2();
        } else {
            synchronized (getEquipo()) {
            try {
                getEquipo().wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (getPosicionInicial() == 66) {
            arrancar3();
        } else {
            synchronized (getEquipo()) {
            try {
                getEquipo().wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   

    /**
     * Método que arrancará al corredor 1 de cada equipo y llegará hasta la
     * posición del corredor 2.
     */
    public void arrancar1() {
        while (true) {
            if (correr(1) >= 33) {
                getEquipo().setPosicion1(33);
                synchronized (getEquipo()) {
                    getEquipo().notifyAll();
                    setPosicionInicial(33);
                }
                break;
            }
        }
    }

    /**
     * Método que arrancará al corredor 2 de cada equipo y llegará hasta la
     * posición del corredor 3.
     */
    public void arrancar2() {
        while (true) {
            if (correr(2) >= 66) {
                getEquipo().setPosicion2(66);
                synchronized (getEquipo()) {
                    getEquipo().notify();
                }
                break;
            }
        }
    }

    /**
     * Método que arrancará al corredor 3 de cada equipo y llegará hasta la
     * línea de meta.
     */
    public void arrancar3() {
        while (true) {
            if (correr(3) >= 100) {
                getEquipo().setPosicion3(100);
                if (getEquipo().getNombreEquipo().equals("Equipo1")) {
                    getEquipo().setNombreEquipo("Equipo 1 (azul)");
                } else if (getEquipo().getNombreEquipo().equals("Equipo2")) {
                    getEquipo().setNombreEquipo("Equipo 2 (Rojo)");
                } else if (getEquipo().getNombreEquipo().equals("Equipo3")) {
                    getEquipo().setNombreEquipo("Equipo 3 (Verde)");
                }
                System.out.println("El equipo ganador es: " + getEquipo().getNombreEquipo());
                System.exit(0);

            }
        }
    }

    /**
     * Método que simulará los pasos que realizarán los corredores para simular
     * la carrera.
     * 
     * @param corredor recibe como parámetro el corredor de cada equipo.
     * @return retorna la posición avanzada por el corredor de cada equipo.
     */
    public int correr(int corredor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ramdon = (int) (Math.random() * 3 + 1);
        if (corredor == 1) {
            getEquipo().setPosicion1(getEquipo().getPosicion1() + ramdon);
            imprimirEquipo();
            return getEquipo().getPosicion1();
        }
        if (corredor == 2) {
            getEquipo().setPosicion2(getEquipo().getPosicion2() + ramdon);
            imprimirEquipo();
            return getEquipo().getPosicion2();
        }
        if (corredor == 3) {
            getEquipo().setPosicion3(getEquipo().getPosicion3() + ramdon);
            imprimirEquipo();
            return getEquipo().getPosicion3();
        }
        return 0;
    }
    
     /**
     * Método sincronizado que imprime las posiciones de los corredores de
     * cada equipo, simulando así la carrera.
     * 
     * @return retorna el puesto del corredor.
     */
    public synchronized String imprimirCorredor() {
        String puesto = "";
        puesto =  equipo.getNombreEquipo();  
        
        for (int i = 0; i <= 100; i++) {
            if (i == equipo.getPosicion1()) {
                puesto += "O";
            } else if (i == equipo.getPosicion2()) {
                puesto += "D";
            } else if (i == equipo.getPosicion3()) {
                puesto += "+";
            } else {
                puesto += "__";
            }
        } 
        return puesto;
    }

    /**
     * Método que imprimirá el puesto de cada corredor para la simulación
     * de la carrera.
     */
    public void imprimirEquipo() {

        if (imprimirCorredor().contains("Equipo1")) {
            setEquipo1(imprimirCorredor());
            if (getEquipo1() != null) {
                System.out.println(getEquipo1());
            }
        } else if (imprimirCorredor().contains("Equipo2")) {
            setEquipo2(imprimirCorredor());
            if (getEquipo2() != null) {
                System.out.println(getEquipo2());
            }
        } else if (imprimirCorredor().contains("Equipo3")) {
            setEquipo3(imprimirCorredor());
            if (getEquipo3() != null) {
                System.out.println(getEquipo3());
            }
        }
    }
    
     

    /**
     * Método que retorna el equipo del corredor.
     * 
     * @return el equipo del corredor.
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Método que recibe el equipo del corredor.
     * 
     * @param equipo recibe como parámetro el equipo del corredor.
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Método que retorna la posición inicial del corredor.
     * 
     * @return la posición inicial del corredor.
     */
    public int getPosicionInicial() {
        return posicionInicial;
    }

    /**
     * Método que recibe la posición inicial del corredor.
     * 
     * @param posicionInicial recibe como parámetro la posición inicial del corredor.
     */
    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    /**
     * Método que retorna la posición actual del corredor 1.
     * 
     * @return retorna la posición actual del corredor 1.
     */
    public String getEquipo1() {
        return equipo1;
    }

    /**
     * Método que recibe la posición actual del corredor 1.
     * 
     * @param equipo1 recibe como parámetro la posición actual del corredor 1.
     */
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * Método que retorna la posición actual del corredor 2.
     * 
     * @return retorna la posición actual del corredor 2.
     */
    public String getEquipo2() {
        return equipo2;
    }

    /**
     * Método que recibe la posición actual del corredor 2.
     * 
     * @param equipo2 recibe como parámetro la posición actual del corredor 2.
     */
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * Método que retorna la posición actual del corredor 3.
     * 
     * @return retorna la posición actual del corredor 3.
     */
    public String getEquipo3() {
        return equipo3;
    }

    /**
     * Método que recibe la posición actual del corredor 3.
     * 
     * @param equipo3 recibe como parámetro la posición actual del corredor 3.
     */
    public void setEquipo3(String equipo3) {
        this.equipo3 = equipo3;
    }
    
}