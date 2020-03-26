/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import cronometro.Cronometro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;


/**
 *
 * @author Estudiantes
 */
public class GUICrono extends JFrame implements ActionListener  {
    
    private Cronometro tempo = new Cronometro();
    private JButton iniciar;
    private JButton detener;
    private JButton reiniciar;
    private Timer timer;
    private TimerTask task;
    
    private JTextField cronoHor;
    private JTextField cronoMinut;
    private JTextField cronoSeg;
    
    private JLabel pts;
    private JLabel pts2;
    
    
    public GUICrono(){
        //Boton para iniciar
        iniciar = new JButton(" Start ");
        iniciar.addActionListener(this);//Escuchar al boton
        iniciar.setActionCommand("start");// Comando del boton
        
        detener = new JButton(" Stop ");
        detener.addActionListener(this);
        detener.setActionCommand("stop");
        
        reiniciar = new JButton(" Reset ");
        reiniciar.addActionListener(this);
        reiniciar.setActionCommand("reset");
        
        cronoHor = new JTextField("0");
        cronoMinut = new JTextField("0");
        cronoSeg = new JTextField("0");
        
        pts = new JLabel(":");
        pts2 = new JLabel(":");
        
        
        
        
        
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(tempo.getEstado()== 1 ){
                tempo.tick();
                cronoHor.setText(String.valueOf(tempo.getHorario().getValorVariable()));
                cronoMinut.setText(String.valueOf(tempo.getMinutero().getValorVariable()));
                cronoSeg.setText(String.valueOf(tempo.getSecundero().getValorVariable())); 
                }
                
            }
        };
        
       timer.schedule(task,0, 1000);
        
        this.getContentPane().setLayout( null );
        this.setBounds( 100 ,100 , 300 , 300 );
        
        this.getContentPane().add(iniciar);
        iniciar.setBounds( 50 , 40 , 80 , 50 );
        
        this.getContentPane().add(detener);
        detener.setBounds( 150 , 40 , 80 , 50 );
        
        this.getContentPane().add(reiniciar);
        reiniciar.setBounds(90 , 150 , 100 , 40 );
        
        this.getContentPane().add(cronoHor);
        cronoHor.setBounds(90 , 100 , 30 , 30 );
        cronoHor.setHorizontalAlignment(JTextField.CENTER);
        
        this.getContentPane().add(cronoMinut);
        cronoMinut.setBounds(130 , 100 , 30 , 30 );
        cronoMinut.setHorizontalAlignment(JTextField.CENTER);
        
        this.getContentPane().add(cronoSeg);
        cronoSeg.setBounds(170 , 100 , 30 , 30 );
        cronoSeg.setHorizontalAlignment(JTextField.CENTER);
        
        this.getContentPane().add(pts);
        pts.setBounds( 122 , 110 , 10 , 10 );
        
        this.getContentPane().add(pts2);
        pts2.setBounds( 162 , 110 , 10 , 10 );
        
        this.setTitle("Cronometro");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("start")){
            if(tempo.getEstado() == 0 ){
                //Si el Cronometro esta en 0 lo inicia y el boton dira pause.
                tempo.iniciar();
                iniciar.setText("Pause");
                
            }else{
                if(tempo.getEstado() == 1){
                    //Si el cronometro esta iniciado y se presiona el boton (pause) se detiene y el boton dira continue.
                    tempo.pausar();
                    iniciar.setText("Continue");
                }else{
                    if(tempo.getEstado() == 2){
                        //Si el cronometro esta pausado y se presiona el boton (continue) se reanudara el conteo y el boton volvera a pause.
                        tempo.iniciar();
                        iniciar.setText(" Pause ");
                    }
                }   
            }
        }
        if(e.getActionCommand().equals("stop")){
            tempo.detener();
            iniciar.setText("Start");
            iniciar.setEnabled(false);
        }
        if(e.getActionCommand().equals("reset")){
            tempo.detener();
            cronoHor.setText("0");
            cronoMinut.setText("0");
            cronoSeg.setText("0");
            tempo.getHorario().setValorVariable(0);
            tempo.getMinutero().setValorVariable(0);
            tempo.getSecundero().setValorVariable(0);
            iniciar.setEnabled(true);
            iniciar.setText("Start");
            
        }
    }
   
}
