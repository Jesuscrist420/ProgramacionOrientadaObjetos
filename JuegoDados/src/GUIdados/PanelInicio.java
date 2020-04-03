/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIdados;

import Exceptions.NegativeException;
import Exceptions.FuncionesException;
import Exceptions.ApuestaVaciaException;
import archivos.Escritor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import juegodados.Jugador;
import juegodados.JuegoDados;


/**
 *
 * @author jrqui
 */
public class PanelInicio extends JFrame implements ActionListener{
    
    Font fuente = new Font("Arial", 3 , 14);
    
    private JLabel nombre1;
    private JLabel saldo1;
    private JLabel juegosJu1;
    private JLabel juegosPer1;
    private JLabel juegosGa1;
    private JLabel apuesta1;
    
    private JLabel nombre;
    private JLabel saldo;
    private JLabel juegosJu;
    private JLabel juegosPer;
    private JLabel juegosGa;
    private JLabel apuesta;
    
    private JButton salir;
    private JButton jugar;
    private JButton instrucciones;
    
    private JButton subir;
    private JButton bajar;
    private ImageIcon arriba;
    private ImageIcon abajo;
  
    private JuegoDados juego;
    private String[] player;
    
    
    public PanelInicio(String[] jugador){
        player = jugador;
        
        juego = new JuegoDados();
        
        salir = new JButton(" Salir ");
        salir.setBackground(Color.BLACK);
        salir.setFont(fuente);
        salir.setForeground(Color.WHITE);
        salir.setFocusable(false);
        salir.addActionListener(this);
        salir.setActionCommand("salir");
        
        instrucciones = new JButton(" Instrucciones ");
        instrucciones.setBackground(Color.BLACK);
        instrucciones.setFont(fuente);
        instrucciones.setForeground(Color.WHITE);
        instrucciones.setFocusable(false);
        instrucciones.addActionListener(this);
        instrucciones.setActionCommand("instrucciones");
        

        jugar = new JButton("Jugar");
        jugar.setBackground(Color.BLACK);
        jugar.setFont(fuente);
        jugar.setForeground(Color.WHITE);
        jugar.setFocusable(false);
        jugar.addActionListener(this);
        jugar.setActionCommand("jugar");
        
        subir = new JButton(new ImageIcon("src/Imagenes/flechaArriba.png"));
        subir.setBackground(Color.CYAN);
        subir.setBorder(null);
        subir.addActionListener(this);
        subir.setActionCommand("aumentar");
        
        bajar = new JButton(new ImageIcon("src/Imagenes/flechaAbajo.png"));
        bajar.addActionListener(this);
        bajar.setBackground(Color.CYAN);
        bajar.setBorder(null);
        bajar.setActionCommand("disminuir");
        
        nombre1 = new JLabel("Nombre:");
        nombre1.setFont(fuente);
        nombre1.setForeground(Color.BLACK);
        saldo1 = new JLabel("Saldo:");
        saldo1.setFont(fuente);
        saldo1.setForeground(Color.BLACK);
        juegosJu1 = new JLabel("Juegos jugados:");
        juegosJu1.setFont(fuente);
        juegosJu1.setForeground(Color.BLACK);
        juegosPer1 = new JLabel("Juegos perdidos:");
        juegosPer1.setFont(fuente);
        juegosPer1.setForeground(Color.BLACK);
        juegosGa1 = new JLabel("Juegos ganados:");
        juegosGa1.setFont(fuente);
        juegosGa1.setForeground(Color.BLACK);
        apuesta1= new JLabel("Apuesta:");
        apuesta1.setFont(fuente);
        apuesta1.setForeground(Color.BLACK);
        
        nombre = new JLabel(player[2]);
        saldo = new JLabel(player[3]);
        juegosJu = new JLabel(player[4]);
        juegosGa = new JLabel(player[5]);
        juegosPer = new JLabel(player[6]);
        apuesta = new JLabel(player[7]);
        
        this.getContentPane().setLayout(null);
        this.setBounds( 100 ,100 , 280 , 400 );
        this.getContentPane().setBackground(Color.cyan);
        //Botones
        
        this.getContentPane().add(salir);
        salir.setBounds( 140 , 270 , 90 , 40 );
        this.getContentPane().add(jugar);
        jugar.setBounds( 40 , 270 , 90 , 40 );
        this.getContentPane().add(instrucciones);
        instrucciones.setBounds( 60 , 220 , 150 , 40 );
        this.getContentPane().add(subir);
        subir.setBounds( 10 , 170 , 20 , 20 );
        this.getContentPane().add(bajar);
        bajar.setBounds( 30 , 170 , 20 , 20 );
        //Labels
        this.getContentPane().add(nombre1);
        nombre1.setBounds( 70 , 10 , 60 , 40 );
        this.getContentPane().add(saldo1);
        saldo1.setBounds( 82 , 40 , 60 , 40 );                
        this.getContentPane().add(juegosJu1);
        juegosJu1.setBounds( 15 , 70 , 120 , 40 );                
        this.getContentPane().add(juegosGa1);
        juegosGa1.setBounds( 10 , 100 , 120 , 40 );        
        this.getContentPane().add(juegosPer1);
        juegosPer1.setBounds( 10 , 130 , 120 , 40 );                
        this.getContentPane().add(apuesta1);
        apuesta1.setBounds( 60 , 160 , 120 , 40 );        
        
        //Labels2
        this.getContentPane().add(nombre);
        nombre.setBounds( 135 , 10 , 90 , 40 );
        this.getContentPane().add(saldo);
        saldo.setBounds( 135 , 40 , 90 , 40 );        
        this.getContentPane().add(juegosJu);
        juegosJu.setBounds( 135 , 70 , 100 , 40 );        
        this.getContentPane().add(juegosGa);
        juegosGa.setBounds( 135 , 100 , 100 , 40 );
        this.getContentPane().add(juegosPer);
        juegosPer.setBounds( 135 , 130 , 100 , 40 );        
        this.getContentPane().add(apuesta);
        apuesta.setBounds( 135 , 160 , 100 , 40 );
        
        this.setTitle("Panel Inicio");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
  
    }

    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("salir")){
            
            GuiInicio inicio = new GuiInicio();  
            this.dispose();
        }
        if(e.getActionCommand().equals("jugar")){
            try {
                if(FuncionesException.verificarApuesta(player[7])){
                    juego.setEstado(1);
                    Juego game = new Juego(player, juego);
                    this.dispose();
                }
                
            } catch (ApuestaVaciaException ex) {
                juego.evaluar();
            } catch (NegativeException ex) {
                juego.evaluar();
            }
        }
        if(e.getActionCommand().equals("instrucciones")){
            Instrucciones instrucciones = new Instrucciones(this);
        }   
        if(e.getActionCommand().equals("aumentar")){
            if(Integer.parseInt(player[3])>=10){
                player[7] = String.valueOf(Integer.parseInt(player[7])+ 10);
                player[3] = String.valueOf(Integer.parseInt(player[3])-10);
                saldo.setText(player[3]);
                apuesta.setText(player[7]);   
            }
        }
        if(e.getActionCommand().equals("disminuir")){
            if(Integer.parseInt(player[3])>=10 && Integer.parseInt(player[7])>0){
                player[7] = String.valueOf(Integer.parseInt(player[7])-10);
                player[3] = String.valueOf(Integer.parseInt(player[3])+10);
                saldo.setText(player[3]);
                apuesta.setText(player[7]);
            }
        }
    }
}
