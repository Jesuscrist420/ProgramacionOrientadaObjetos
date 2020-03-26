package GUIdados;
import archivos.Escritor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import juegodados.Jugador;
import juegodados.JuegoDados;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jrqui
 */
public class Juego extends JFrame implements ActionListener {

    private JButton lanzar;
    private JButton salir;
    private JLabel numJuego;
    private JLabel apuesta;
    private JLabel dado1;
    private JLabel dado2;
    Font fuente = new Font("Arial", 3 , 28);
    Font fuente2 = new Font("Arial", 3 , 16);
    Font fuente3 = new Font("Arial",3 , 14 );
    
    private JuegoDados game;
    private String[] player;
    private ImageIcon imgDado1;
    private ImageIcon imgDado2;
    
    private Timer timer;
    private TimerTask task;
    
    private Random r1;
    private Random r2;
    private int in1;
    private int in2;
    
    private int estado1;
    private int valor;
    private int contador;
    
    
    

  
   public void cambiarImg(){
       in1 =r1.nextInt(5)+1;
       in2 =r2.nextInt(5)+1;
       imgDado1= new ImageIcon("src/Imagenes/dado"+String.valueOf((in1))+".png");
       imgDado2 = new ImageIcon("src/Imagenes/dado"+String.valueOf(in2)+".png");
       game.setValor(in1+in2);
       if(game.getLanzamiento() == 1){
           game.setValorAnt(game.getValor());
       }
       dado1.setIcon(imgDado1);
       dado2.setIcon(imgDado2);
   }
   public void mostrarResultado(String[] jugador , JuegoDados juego){
        
        if(valor == 1){
            JOptionPane.showMessageDialog(null, "Has Ganado" ,"Ganador" , JOptionPane.INFORMATION_MESSAGE );
            game.ganar(jugador);
            PanelInicio inicio = new PanelInicio(jugador);
            Escritor escribe = new Escritor();
            try {
                escribe.guardar("src/archivos/archivo.txt", jugador);
                   
            }catch(IOException ex) {
                System.out.println(ex);
            }
            this.dispose();

        }else{
            if(valor == 2){
            JOptionPane.showMessageDialog(null, "Has Perdido" , "Perdedor" , JOptionPane.ERROR_MESSAGE);
            game.perder(jugador);
            PanelInicio inicio = new PanelInicio(jugador);
            Escritor escribe = new Escritor();
            try {
                escribe.guardar("src/archivos/archivo.txt", jugador);
                   
            }catch(IOException ex) {
                System.out.println(ex);
            }
            this.dispose();
            }
        }
    }
   
    public Juego( String[] jugador, JuegoDados juego){
                
        player = jugador;
        game = juego;
        estado1 = 0;
        r1 = new Random();
        r2 = new Random();
        valor = 0;
        
 
        lanzar = new JButton(" Lanzar ");
        lanzar.setBackground(Color.BLUE);
        lanzar.setFont(fuente3);
        lanzar.setForeground(Color.WHITE);
        lanzar.setFocusable(false);
        lanzar.addActionListener(this);//Escuchar al boton
        lanzar.setActionCommand("lanzar");// Comando del boton
        
        salir = new JButton(" Salir ");
        salir.setBackground(Color.red);
        salir.setFont(fuente3);
        salir.setForeground(Color.WHITE);
        salir.setFocusable(false);
        salir.addActionListener(this);//Escuchar al boton
        salir.setActionCommand("salir");// Comando del boton
        
        numJuego = new JLabel("Juego #"+ String.valueOf(Integer.parseInt(player[4])+1));
        numJuego.setFont(fuente);
        numJuego.setForeground(Color.WHITE);
        apuesta = new JLabel("Apuesta: "+ jugador[7]);
        apuesta.setFont(fuente2);
        apuesta.setForeground(Color.WHITE);
        
        imgDado1 = new ImageIcon("src/Imagenes/dado"+"1"+".png");
        imgDado2 = new ImageIcon("src/Imagenes/dado"+"2"+".png");
        
        dado1 = new JLabel(imgDado1);
        dado2 = new JLabel(imgDado2);
        
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(estado1 == 1 & contador<6){
                    cambiarImg();
                    contador++;
                }else{
                    if(estado1 == 1){
                        game.setEstado(game.juego());
                        valor = game.getEstado();
                        mostrarResultado(player , game);
                        estado1=2;
                    }
                }  
            }
        };
        
        timer.schedule(task,0, 100);
        
        
        
        this.getContentPane().setLayout(null);
        this.setBounds( 100 ,100 , 280 , 400 );
        this.getContentPane().setBackground(Color.BLACK);
        
        this.getContentPane().add(lanzar);
        lanzar.setBounds( 30 , 250 , 90 , 40 ); 
        this.getContentPane().add(salir);
        salir.setBounds( 145 , 250 , 90 , 40 );
        
        
        this.getContentPane().add(numJuego);
        numJuego.setBounds( 60 , 20 , 140 , 80 );
        this.getContentPane().add(apuesta);
        apuesta.setBounds( 85 , 70 , 120 , 60 );
        this.getContentPane().add(dado1);
        dado1.setBounds( 50 , 150 , 90 , 40 );
        this.getContentPane().add(dado2);
        dado2.setBounds( 120 , 150 , 90 , 40 );
        
        
        this.setTitle("Juego");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("lanzar")){
            
            game.jugar();
            this.estado1 = 1;
            contador = 0;
            
      
        }
        if(e.getActionCommand().equals("salir")){
            PanelInicio inicio = new PanelInicio(player);
            this.dispose();
        }
        
    } 
}



