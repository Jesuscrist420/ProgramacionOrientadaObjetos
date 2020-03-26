package cronometro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiantes
 */
public class Aguja {
    
    private int valorMaximo;
    private int valorVariable;
    
    public Aguja(){
        this.valorMaximo = 0;
        this.valorVariable = 0;
    }
    
    public Aguja(int num1, int num2){
        this.valorMaximo = num1;
        this.valorVariable = num2;
    }
    
    public Aguja( Aguja aguj){
        this.valorMaximo = aguj.valorMaximo;
        this.valorVariable = aguj.valorVariable;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getValorVariable() {
        return valorVariable;
    }

    public void setValorVariable(int valorVariable) {
        this.valorVariable = valorVariable;
    }
    
    
    public final void mover(){
        this.valorVariable++;
        if(this.valorVariable == this.valorMaximo){
            this.valorVariable = 0;
        }
        
    }
   
}
