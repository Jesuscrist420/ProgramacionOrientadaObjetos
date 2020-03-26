/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIdados;

import Exceptions.NegativeException;
import Exceptions.FuncionesException;
import Exceptions.RegistroVacioException;
import archivos.Escritor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author jrqui
 */
public class Registro extends JFrame implements ActionListener {
    
    Font fuente = new Font("Arial", 3 , 14);
    Font fuente2 = new Font("Arial", 3 , 12);
    
    private JTextField usuarioRegistro;
    private JTextField nombreRegistro;
    private JPasswordField passwordRegistro;
    private JTextField saldoRegistro;
    
    private JLabel usuarioLabReg;
    private JLabel nombreLabReg;
    private JLabel passwordLabReg;
    private JLabel saldoLabReg;
    
    private JButton guardar;
    private JButton salir;
    
    public Registro(){
        
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);  
        NumberFormatter numberFormatter = new NumberFormatter(format);
        numberFormatter.setValueClass(Integer.class);
        numberFormatter.setMaximum(Integer.MAX_VALUE);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setCommitsOnValidEdit(true);
        
        usuarioRegistro = new JTextField();
        nombreRegistro = new JTextField();
        passwordRegistro = new JPasswordField();
        saldoRegistro = new JFormattedTextField(numberFormatter);
        
        usuarioLabReg = new JLabel("Usuario");
        usuarioLabReg.setFont(fuente);
        usuarioLabReg.setForeground(Color.BLACK);
        nombreLabReg = new JLabel("Nombre");
        nombreLabReg.setFont(fuente);
        nombreLabReg.setForeground(Color.BLACK);
        passwordLabReg = new JLabel("Password");
        passwordLabReg.setFont(fuente);
        passwordLabReg.setForeground(Color.BLACK);
        saldoLabReg = new JLabel("Saldo");
        saldoLabReg.setFont(fuente);
        saldoLabReg.setForeground(Color.BLACK);
        
        guardar = new JButton("Guardar");
        guardar.setBackground(Color.BLACK);
        guardar.setFont(fuente2);
        guardar.setForeground(Color.WHITE);
        guardar.setFocusable(false);
        guardar.addActionListener(this);
        guardar.setActionCommand("guardar");
        
        salir = new JButton("Salir");
        salir.setBackground(Color.BLACK);
        salir.setFont(fuente2);
        salir.setForeground(Color.WHITE);
        salir.setFocusable(false);
        salir.addActionListener(this);
        salir.setActionCommand("salir");
        
        //Crea la ventana
        this.getContentPane().setLayout(null);
        this.setBounds( 100 ,100 , 280 , 400 );
        this.getContentPane().setBackground(Color.CYAN);
        
        //Etiquetas para nombrar los textfields
        this.getContentPane().add(usuarioLabReg);
        usuarioLabReg.setBounds(50 , 35 , 70 , 30);
        this.getContentPane().add(nombreLabReg);
        nombreLabReg.setBounds(50 , 90 , 70 , 30);
        this.getContentPane().add(passwordLabReg);
        passwordLabReg.setBounds(50 , 145 , 70 , 30);
        this.getContentPane().add(saldoLabReg);
        saldoLabReg.setBounds(50 , 200 , 70 , 30);
        
        //Textfield y ubicaciones
        this.getContentPane().add(usuarioRegistro);
        usuarioRegistro.setBounds(50 , 60 , 180 , 30);
        this.getContentPane().add(nombreRegistro);
        nombreRegistro.setBounds(50 , 115 , 180 , 30);
        this.getContentPane().add(passwordRegistro);
        passwordRegistro.setBounds(50 , 170 , 180 , 30);
        this.getContentPane().add(saldoRegistro);
        saldoRegistro.setBounds(50 , 225 , 180 , 30);
        
        //Botones y Ubicaciones
        this.getContentPane().add(guardar);
        guardar.setBounds(150 , 280 , 90 , 40);
        this.getContentPane().add(salir);
        salir.setBounds(50 , 280 , 90 , 40);
  
        
        
        
        this.setTitle("Inicio");
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
        if(e.getActionCommand().equals("guardar")){
            Escritor escribe = new Escritor();
            try {
                FuncionesException.regVacio(usuarioRegistro.getText(), nombreRegistro.getText(), String.valueOf(passwordRegistro.getPassword()), saldoRegistro.getText());
                int saldo = FuncionesException.numNeg(saldoRegistro.getText());
                escribe.escribeContenido("src/archivos/archivo.txt", usuarioRegistro.getText(), String.valueOf(passwordRegistro.getPassword()) , nombreRegistro.getText(), String.valueOf(saldoRegistro.getText()) );
                GuiInicio inicio = new GuiInicio();
                this.dispose();
            }catch (NegativeException ex) {
                JOptionPane.showMessageDialog(null, "Su saldo es negativo", "Saldo negativo", JOptionPane.ERROR_MESSAGE);
            }catch (IOException ex) {
                System.out.println(ex);
            } catch (RegistroVacioException ex) {
                JOptionPane.showMessageDialog(null, "No ha completado el registro","Registro vacio" , JOptionPane.ERROR_MESSAGE);
            } 
            
        }
    }
}
