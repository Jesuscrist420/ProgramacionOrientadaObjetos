/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

/**
 *
 * @author Estudiantes
 */
public class Jugador {
    private String nombre;
    private String contraseña;
    private int saldo; 
    private int juegosJugados;
    private int juegosPerdidos;
    private int juegosGanados;
    private int apuesta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getJuegosJugados() {
        return juegosJugados;
    }
    public void setJuegosJugados(int juegosJugados) {
        this.juegosJugados = juegosJugados;
    }

    public int getJuegosPerdidos() {
        return juegosPerdidos;
    }
    public void setJuegosPerdidos(int juegosPerdidos) {
        this.juegosPerdidos = juegosPerdidos;
    }

    public int getJuegosGanados() {
        return juegosGanados;
    }
    public void setJuegosGanados(int juegosGanados) {
        this.juegosGanados = juegosGanados;
    }

    public int getApuesta() {
        return apuesta;
    }
    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }
    
    
 
    public Jugador(){
        
        this.nombre = "";
        this.contraseña = "";
        this.saldo = 0;
        this.juegosGanados = 0;
        this.juegosPerdidos = 0;
        this.juegosJugados = 0;
        this.apuesta = 0;
    }
 
}
