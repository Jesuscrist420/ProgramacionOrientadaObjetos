/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIdados;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author jrqui
 */
public class Instrucciones extends JFrame implements ActionListener{
    Font fuente = new Font("Arial", 3 , 14);
    
    private JButton ok;
    private JLabel inst;
    private JLabel inst2;
    private String texto;
    private PanelInicio panel1;
    
    public Instrucciones (PanelInicio panel){
        panel1 = panel;
        panel1.setEnabled(false);
        panel1.setVisible(false);
        texto = "<html><body>1.Si en el primer lanzamiento saca:<br>7 o 11, felicitaciones, ha Ganado.<br><br>2.Si en el primer lanzamiento saca:<br>2 o 3 o 12, lo sentimos, ha perdido.<br><br>3.Si saca un valor diferente debe seguir tirando hasta sacar el mismo valor para ganar o perder si saca : 7.<br><br>4.No puede empezar si no ha realizado la apuesta</body></html>";
        ok = new JButton("Ok");
        ok.addActionListener(this);
        ok.setFont(fuente);
        ok.setForeground(Color.BLACK);
        ok.setBackground(Color.WHITE);
        ok.setFocusable(false);
        ok.setActionCommand("ok");
        
        inst = new JLabel("Instrucciones");
        inst.setFont(fuente);
        inst.setForeground(Color.WHITE);
        inst.setBackground(Color.BLACK);
        
        inst2 = new JLabel("");
        inst2.setText(texto);
        inst2.setForeground(Color.WHITE);
        inst2.setBackground(Color.BLACK);
        
        this.getContentPane().setLayout(null);
        this.setBounds( 100 ,100 , 280 , 400 );
        this.getContentPane().setBackground(Color.BLACK);
        
        this.getContentPane().add(ok);
        ok.setBounds( 90 , 270 , 90 , 40 );
        
        this.getContentPane().add(inst);
        inst.setBounds( 90 , 10 , 140 , 40 );
        
        this.getContentPane().add(inst2);
        inst2.setBounds( 30 , 40 , 200 , 220 );
        
        this.setTitle("Instrucciones");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ok")){
            this.dispose();
            panel1.setEnabled(true);
            panel1.setVisible(true);
        }
                    
    }
    
}
