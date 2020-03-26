package gui;

import calculadoracomplejos.Complejo;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Estudiantes
 */
public class GUI extends JFrame implements ActionListener{
    private Complejo rta;
    private double rtaNorma1;
    private double rtaNorma2;
    private Complejo rtaConjug1;
    private Complejo rtaConjug2;
    
    private int numBoton;
    
    private JButton sumar;
    private JButton restar;
    private JButton multiplicar;
    private JButton dividir;
    private JButton norma;
    private JButton conjugada;
    private JButton equals;
    private JButton clean;
    
    private JTextField parteReal;
    private JTextField parteImag;
    private JTextField parteReal2;
    private JTextField parteImag2;
    
    
    private JLabel etiComplejo; 
    private JLabel etiComplejo2;
    private JLabel etiReal;
    private JLabel etiImag;
    private JLabel etiI;
    private JLabel etiI2;
    private JLabel etiRta;
    
    public GUI(){
        
        rta = new Complejo();
        numBoton = 0; 
        rtaNorma1= 0;
        rtaNorma2= 0;
        rtaConjug1 = new Complejo();
        rtaConjug2 = new Complejo();
        sumar = new JButton("Sumar");
        sumar.addActionListener(this);
        sumar.setActionCommand("+");
        
        restar = new JButton("Restar");
        restar.addActionListener(this);
        restar.setActionCommand("-");
        
        multiplicar = new JButton("Multiplicar");
        multiplicar.addActionListener(this);
        multiplicar.setActionCommand("*");
        
        dividir = new JButton("Dividir");
        dividir.addActionListener(this);
        dividir.setActionCommand("/");
        
        norma = new JButton("Norma");
        norma.addActionListener(this);
        norma.setActionCommand("Nor");
        
        conjugada = new JButton("Conjugada");
        conjugada.addActionListener(this);
        conjugada.setActionCommand("Con");
     
        equals = new JButton("=");
        equals.addActionListener(this);
        equals.setActionCommand("=");
        
        clean = new JButton("AC");
        clean.addActionListener(this);
        clean.setActionCommand("AC");
        
        parteReal = new JTextField("");
        parteImag = new JTextField("");
        parteReal2 = new JTextField("");
        parteImag2 = new JTextField("");
        
       
        etiComplejo = new JLabel("Complejo 1");
        etiComplejo2 = new JLabel("Complejo 2");
        etiReal = new JLabel("Real");
        etiImag = new JLabel("Imaginario");
        etiI = new JLabel("i");
        etiI2 = new JLabel ("i");
        etiRta = new JLabel("Respuesta");
        
        
        // Se crea una ventana sin matriz
        this.getContentPane().setLayout( null );
        //Ubicacion y tama�o de la ventana
        this.setBounds( 100 ,100 , 300 , 400 );
        
        this.getContentPane().add(etiComplejo);
        etiComplejo.setBounds( 10 , 40 , 70 , 30 );
        
        this.getContentPane().add(etiComplejo2);
        etiComplejo2.setBounds( 10 ,80 , 70 , 30 );
        
        this.getContentPane().add(etiReal);
        etiReal.setBounds( 80 , 10 , 60 , 30 );
        
        this.getContentPane().add(parteReal);
        parteReal.setBounds( 80 , 40 , 60 , 30 );
        
        this.getContentPane().add(parteReal2);
        parteReal2.setBounds( 80 , 80 , 60 , 30 );
        
        this.getContentPane().add(etiImag);
        etiImag.setBounds( 160 , 10 , 80 , 30 );
        
        this.getContentPane().add(parteImag);
        parteImag.setBounds( 160 , 40 , 60 , 30 );
        
        this.getContentPane().add(parteImag2);
        parteImag2.setBounds( 160 , 80 , 60 , 30 );
        
        this.getContentPane().add(etiI);
        etiI.setBounds( 225 , 40 , 60 , 30 );
        
        this.getContentPane().add(etiI2);
        etiI2.setBounds ( 225 , 80 , 60 , 30 );
        
        this.getContentPane().add(etiRta);
        etiRta.setBounds ( 80 , 260 , 180 , 50 );
        
        
        this.getContentPane().add(sumar);
        sumar.setBounds(10 , 120 , 80, 30);
        
        this.getContentPane().add(restar);
        restar.setBounds(100, 120, 80, 30);
        
        this.getContentPane().add(multiplicar);
        multiplicar.setBounds(10, 160, 80, 30);
        
        this.getContentPane().add(dividir);
        dividir.setBounds(100, 160, 80, 30);
        
        this.getContentPane().add(norma);
        norma.setBounds(190 , 120, 80, 30);
        
        this.getContentPane().add(conjugada);
        conjugada.setBounds(190, 160, 80, 30);
        
        this.getContentPane().add(equals);
        equals.setBounds(70, 200, 70, 30);
        
        this.getContentPane().add(clean);
        clean.setBounds(150, 200, 70, 30);
        
        
        this.setTitle("Calculadora Complejos");
        this.setResizable(true);      
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getActionCommand().equals("+")){
            numBoton = 1;
            Complejo num1 = new Complejo( Float.parseFloat(parteReal.getText()) , Float.parseFloat(parteImag.getText()) );
            Complejo num2 = new Complejo( Float.parseFloat(parteReal2.getText()) , Float.parseFloat(parteImag2.getText()) );
            rta = num1.suma(num2);
        }
        
        if(e.getActionCommand().equals("-")){
            numBoton = 1;
            Complejo num1 = new Complejo(Float.parseFloat(parteReal.getText()) , Float.parseFloat(parteImag.getText()));
            Complejo num2 = new Complejo( Float.parseFloat(parteReal2.getText()) , Float.parseFloat(parteImag2.getText()) );
            rta = num1.resta(num2);
            
        }
        if(e.getActionCommand().equals("*")){
            numBoton = 1;
            Complejo num1 = new Complejo(Float.parseFloat(parteReal.getText()) , Float.parseFloat(parteImag.getText()));
            Complejo num2 = new Complejo(Float.parseFloat(parteReal2.getText()) , Float.parseFloat(parteImag2.getText()));
            rta = num1.multiplicacion(num2);
        }
        if(e.getActionCommand().equals("/")){
            numBoton = 2;
            Complejo num1 = new Complejo(Float.parseFloat(parteReal.getText()) , Float.parseFloat(parteImag.getText()));
            Complejo num2 = new Complejo(Float.parseFloat(parteReal2.getText()) , Float.parseFloat(parteImag2.getText()));
            rta = num1.division(num2);
          
        }
        if(e.getActionCommand().equals("Nor")){
            numBoton = 3;
            Complejo num1 = new Complejo(Float.parseFloat(parteReal.getText()) , Float.parseFloat(parteImag.getText()));
            Complejo num2 = new Complejo(Float.parseFloat(parteReal2.getText()) , Float.parseFloat(parteImag2.getText()));
            rtaNorma1 = num1.norma();
            rtaNorma2 = num2.norma();
        }
        if(e.getActionCommand().equals("Con")){
            numBoton = 4;
            Complejo num1 = new Complejo(Float.parseFloat(parteReal.getText()), Float.parseFloat(parteImag.getText()));
            Complejo num2 = new Complejo(Float.parseFloat(parteReal2.getText()), Float.parseFloat(parteImag2.getText()));
            rtaConjug1 = num1.conjugada();
            rtaConjug2 = num2.conjugada();
        }
        if(e.getActionCommand().equals("=")){
            switch(numBoton){
                case 1:{
                    if (rta.getParteImag()>=0){
                       etiRta.setText(Double.toString(rta.getParteReal()) +" + "+ Double.toString(rta.getParteImag())+ "i"); 
                    }else{
                       etiRta.setText(Double.toString(rta.getParteReal()) + Double.toString(rta.getParteImag())+ "i"); 
                    }
                    break;
                }
                case 2:{
                    if (rta.getParteImag()>=0){
                       etiRta.setText(Float.toString((float)rta.getParteReal()) +" + "+ Float.toString((float)rta.getParteImag())+ "i"); 
                    }else{
                       etiRta.setText(Float.toString((float)rta.getParteReal()) + Float.toString((float)rta.getParteImag())+ "i"); 
                    }
                    break;
                }
                case 3:{
                    etiRta.setText("<html><body>Norma 1: " + Float.toString((float)rtaNorma1)+ "<br>Norma 2:" + Float.toString((float)rtaNorma2) + "</body></html>");
                    break;
                }
                case 4:{
                    
                    if (rtaConjug1.getParteImag()>=0 && rtaConjug2.getParteImag()>=0){
                       etiRta.setText("<html><body>Conjugada 1: " + Float.toString((float)rtaConjug1.getParteReal())+" + "+Float.toString((float)rtaConjug1.getParteImag()) + "<br>Conjugada 2: " + Float.toString((float)rtaConjug2.getParteReal()) +" + "+ Float.toString((float)rtaConjug2.getParteImag()) +"</body></html>");
                    }else{
                        if (rtaConjug1.getParteImag()>=0 && 0>=rtaConjug2.getParteImag()){
                            etiRta.setText("<html><body>Conjugada 1: " + Float.toString((float)rtaConjug1.getParteReal())+" + "+Float.toString((float)rtaConjug1.getParteImag()) + "<br>Conjugada 2: " + Float.toString((float)rtaConjug2.getParteReal()) +" "+ Float.toString((float)rtaConjug2.getParteImag()) +"</body></html>");
                        }else{
                            if( 0>=rtaConjug1.getParteImag() && rtaConjug2.getParteImag()>=0){
                                etiRta.setText("<html><body>Conjugada 1: " + Float.toString((float)rtaConjug1.getParteReal())+" "+Float.toString((float)rtaConjug1.getParteImag()) + "<br>Conjugada 2: " + Float.toString((float)rtaConjug2.getParteReal()) +" + "+ Float.toString((float)rtaConjug2.getParteImag()) +"</body></html>");
                            }else{
                                etiRta.setText("<html><body>Conjugada 1: " + Float.toString((float)rtaConjug1.getParteReal())+" "+Float.toString((float)rtaConjug1.getParteImag()) + "<br>Conjugada 2: " + Float.toString((float)rtaConjug2.getParteReal()) +" "+ Float.toString((float)rtaConjug2.getParteImag()) +"</body></html>");
                            }
                        }
     
                    }
                    break;
                }
                default:{
                    
                }
                   
            }
          
        }
        if(e.getActionCommand().equals("AC")){
            parteReal.setText(" ");
            parteImag.setText(" ");
            parteReal2.setText(" ");
            parteImag2.setText(" ");
            etiRta.setText(" Respuesta ");
        }
    }

    
   
}
