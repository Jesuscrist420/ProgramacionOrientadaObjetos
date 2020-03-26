/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIdados;

import archivos.Lector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import juegodados.JuegoDados;
import juegodados.Jugador;

/**
 *
 * @author Estudiantes
 */
public class GuiInicio extends JFrame implements ActionListener {

    private JTextField usuarioTxt;
    private JPasswordField passTxt;
    Font fuente = new Font("Arial", 3 , 14);
    Font fuente2 = new Font("Arial", 3 , 12);
    
    
    private JLabel usuarioLabel;
    private JLabel passLabel;
    private JLabel imagen;
    private ImageIcon img;
    
    private JButton iniciar;
    private JButton registro;
    
    private Jugador player;
    
    public GuiInicio(){
        
        iniciar = new JButton(" Iniciar ");
        iniciar.setBackground(Color.BLACK);
        iniciar.setFont(fuente2);
        iniciar.setForeground(Color.WHITE);
        iniciar.setFocusable(false);
        iniciar.addActionListener(this);//Escuchar al boton
        iniciar.setActionCommand("iniciar");// Comando del boton
        
        registro = new JButton(" Registro ");
        registro.setBackground(Color.BLACK);
        registro.setFont(fuente2);
        registro.setFocusable(false);
        registro.setForeground(Color.WHITE);
        registro.addActionListener(this);
        registro.setActionCommand("registro");
        
        img = new ImageIcon("src/Imagenes/DadosInicio2.png");
        
        usuarioTxt = new JTextField();
        passTxt = new JPasswordField();
        
        usuarioLabel = new JLabel("Usuario");
        usuarioLabel.setForeground(Color.BLACK);
        usuarioLabel.setFont(fuente); 
        
        imagen = new JLabel(img);
        imagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(130 , 130 , Image.SCALE_DEFAULT)));
       
        passLabel = new JLabel("Password");
        passLabel.setForeground(Color.BLACK);
        passLabel.setFont(fuente); 
        
        this.getContentPane().setLayout(null);
        this.setBounds( 100 ,100 , 280 , 400 );
        this.getContentPane().setBackground(Color.CYAN);
        
        this.getContentPane().add(iniciar);
        iniciar.setBounds( 40 , 280 , 90 , 40 );
        
        this.getContentPane().add(registro);
        registro.setBounds( 140 , 280 , 90 , 40 );
        
        this.getContentPane().add(usuarioTxt);
        usuarioTxt.setBounds(45 , 170 , 180 , 30);
        
        this.getContentPane().add(passTxt);
        passTxt.setBounds( 45 , 225 ,180 , 30 );
        
        this.getContentPane().add(imagen);
        imagen.setBounds( 60 , 20 , 130 , 130);
        
        this.getContentPane().add(usuarioLabel);
        usuarioLabel.setBounds( 45 , 145 , 70 , 30 );
        
        
        this.getContentPane().add(passLabel);
        passLabel.setBounds( 45 , 198 , 70 , 30 );
        
        
        this.setTitle("Inicio");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("iniciar")){
            Lector lee = new Lector();
            try{
                int estado = lee.evaluarUsuarios("src/archivos/archivo.txt", usuarioTxt.getText(), String.valueOf(passTxt.getPassword()));
                if(estado == 1){
                    String[] player = lee.traerUsuario("src/archivos/archivo.txt", usuarioTxt.getText());
                    PanelInicio game = new PanelInicio(player);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario o password incorrectos.", "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }catch(IOException ex){
                System.out.println(ex);
            }
            
        }
        if(e.getActionCommand().equals("registro")){
            Registro reg = new Registro();
            this.dispose();
                
        }
        
    }
    
}
