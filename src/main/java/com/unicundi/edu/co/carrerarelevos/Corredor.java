/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicundi.edu.co.carrerarelevos;

/**
 *
 * @author dparr
 */
public class Corredor extends Thread {

    private Equipo equipo;
    private String nombreEquipo;
    private int posiciondeInicio;
    private String equipo1;
    private String equipo2;
    private String equipo3;

    public Corredor(Equipo equipo, String nombreEquipo, int posiciondeInicio ) {
        this.nombreEquipo = nombreEquipo;
        this.posiciondeInicio = posiciondeInicio;
        this.equipo = equipo;
    }

    @Override

    public void run() {
        if (getPosiciondeInicio() == 0) {
            avanzaCorredor1();
        } else {
            esperar();
        }
        if (getPosiciondeInicio() == 33) {
            avanzaCorredor2();
        } else {
            esperar();
        }
        if (getPosiciondeInicio() == 66) {
            avanzaCorredor3();
        } else {
            esperar();
        }
    }

    public void avanzaCorredor1() {
        while (true) {
            int posicion = correr(1);
            if (posicion >= 33) {
                getEquipo().setPosicion1(33);
                synchronized (getEquipo()) {
                    getEquipo().notifyAll();
                    setPosiciondeInicio(33);
                }
                break;
            }
        }
    }

    public void avanzaCorredor2() {
        while (true) {
            int posicion = correr(2);
            if (posicion >= 66) {
                getEquipo().setPosicion2(66);
                synchronized (getEquipo()) {
                    getEquipo().notify();
                }
                break;
            }
        }
    }

    public String avanzaCorredor3() {
        while (true) {
            int posicion = correr(3);
            if (posicion >= 100) {
                getEquipo().setPosicion3(100);
                if (getEquipo().getNombreEquipo().equals("Equipo1")) {
                    getEquipo().setNombreEquipo("Equipo 1 (azul)");
                } else if (getEquipo().getNombreEquipo().equals("Equipo2")) {
                    getEquipo().setNombreEquipo("Equipo 2 (Rojo)");
                } else if (getEquipo().getNombreEquipo().equals("Equipo3")) {
                    getEquipo().setNombreEquipo("Equipo 3 (Verde)");
                }
                String cadena = "El " + getEquipo().getNombreEquipo() + " Gana la carrera !!!";
                System.out.println("El equipo ganador es: " + getEquipo().getNombreEquipo());
                System.exit(0);
                return cadena;

            }
        }
    }

    public void esperar() {
        synchronized (getEquipo()) {
            try {
                getEquipo().wait();
            } catch (InterruptedException ex) {
                ex.getMessage();
                System.out.println("Error en Metodo Esperar");
            }
        }
    }

    public int correr(int corre) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.getMessage();
            System.out.println("Error en el Metodo Correr");
        }
        int numRam = generarNumeroRandom();
        if (corre == 1) {
            getEquipo().setPosicion1(getEquipo().getPosicion1() + numRam);
            mostrarEquipo();
            return getEquipo().getPosicion1();
        }
        if (corre == 2) {
            getEquipo().setPosicion2(getEquipo().getPosicion2() + numRam);
            mostrarEquipo();
            return getEquipo().getPosicion2();
        }
        if (corre == 3) {
            getEquipo().setPosicion3(getEquipo().getPosicion3() + numRam);
            mostrarEquipo();
            return getEquipo().getPosicion3();
        }
        return 0;
    }
    
    public static int generarNumeroRandom(){
        int numero = (int) (Math.random() * 3 + 1);
        return numero;
    }

    public void mostrarEquipo() {

        if (getEquipo().imprimirPuesto().contains("Equipo1")) {
            setEquipo1(getEquipo().imprimirPuesto());
            if (getEquipo1() != null) {
                System.out.println(getEquipo1());
            }
        } else if (getEquipo().imprimirPuesto().contains("Equipo2")) {
            setEquipo2(getEquipo().imprimirPuesto());
            if (getEquipo2() != null) {
                System.out.println(getEquipo2());
            }
        } else if (getEquipo().imprimirPuesto().contains("Equipo3")) {
            setEquipo3(getEquipo().imprimirPuesto());
            if (getEquipo3() != null) {
                System.out.println(getEquipo3());
            }
        }

    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * @param equipo the equipo to set
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * @return the nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * @param nombreEquipo the nombreEquipo to set
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * @return the posiciondeInicio
     */
    public int getPosiciondeInicio() {
        return posiciondeInicio;
    }

    /**
     * @param posiciondeInicio the posiciondeInicio to set
     */
    public void setPosiciondeInicio(int posiciondeInicio) {
        this.posiciondeInicio = posiciondeInicio;
    }

    /**
     * @return the equipo1
     */
    public String getEquipo1() {
        return equipo1;
    }

    /**
     * @param equipo1 the equipo1 to set
     */
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * @return the equipo2
     */
    public String getEquipo2() {
        return equipo2;
    }

    /**
     * @param equipo2 the equipo2 to set
     */
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * @return the equipo3
     */
    public String getEquipo3() {
        return equipo3;
    }

    /**
     * @param equipo3 the equipo3 to set
     */
    public void setEquipo3(String equipo3) {
        this.equipo3 = equipo3;
    }
    
    
}