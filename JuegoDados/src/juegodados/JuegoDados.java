 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

import GUIdados.Juego;
import GUIdados.PanelInicio;
import archivos.Escritor;
import java.io.IOException;
import javax.swing.JOptionPane;
import juegodados.Dado;
import juegodados.Jugador;

/**
 *
 * @author Estudiantes
 */
public class JuegoDados{
    
    
    Jugador player;
    Dado dado;
    Dado dado2;
    private int valor;
    private int valorAnt;
    private int lanzamiento;
    private int estado;
    

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public Dado getDado2() {
        return dado2;
    }

    public void setDado2(Dado dado2) {
        this.dado2 = dado2;
    }

    public int getValorAnt() {
        return valorAnt;
    }

    public void setValorAnt(int valorAnt) {
        this.valorAnt = valorAnt;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
  
    
    
    
    
    public void jugar(){
        lanzamiento++;
    }
    
    public int juego(){
        if(valor == 0){
            return 0;
        }
            
        if(lanzamiento == 1){
            if( valor == 7 || valor == 11){
                player.setSaldo(player.getSaldo() + player.getApuesta());
                return 1;
            }else{
                if(valor == 2 || valor == 3 || valor == 12){
                    player.setSaldo(player.getSaldo()-player.getApuesta());
                    return 2;
                }else{
                    valorAnt = valor; 
                    return 3;               
                }
            }
        }else{
            if(valor ==  valorAnt){
                return 1;
            }else{
                if(valor == 7){
                    return 2;
                }else{
                    return 3;
                }                   
            }    
        }  
    }
    public void evaluar(){
       
            JOptionPane.showMessageDialog(null , "No has realizado tu apuesta" , "Apuesta" , JOptionPane.ERROR_MESSAGE);     
    }
     
    
    
    public void ganar(String[] jugador){
        jugador[3] = String.valueOf(Integer.parseInt(jugador[3])+2*Integer.parseInt(jugador[7]));
        jugador[4] = String.valueOf(Integer.parseInt(jugador[4])+1) ;
        jugador[5] = String.valueOf(Integer.parseInt(jugador[5])+1);
        jugador[7] = String.valueOf(0);
    }
    public void perder(String[] jugador){
        jugador[3] = String.valueOf(Integer.parseInt(jugador[3]));
        jugador[4] = String.valueOf(Integer.parseInt(jugador[4])+1);
        jugador[6] = String.valueOf(Integer.parseInt(jugador[6])+1);
        jugador[7] = String.valueOf(0);
    }
    
      
    
    
    
    
    public JuegoDados(){
        
       player = new Jugador();
       dado = new Dado();
       dado2 = new Dado();
       valor = 0;
       valorAnt = 0;
       lanzamiento = 0;
       estado = 0;
     
    }
    
    
    
}
