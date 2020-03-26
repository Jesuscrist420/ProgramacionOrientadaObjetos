/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoracomplejos;

/**
 *
 * @author jrqui
 */
public class Complejo { //Clase
    private float parteReal;   //Atributos 
    private float parteImag;
    //Constructores
    public Complejo(){
       this.parteReal=0;
       this.parteImag=0;
    }
    
    public Complejo(float parteReal, float parteImag){
        this.parteReal= parteReal;
        this.parteImag= parteImag;
    }
    
    public Complejo(Complejo c1){
        this.parteReal= c1.parteReal;
        this.parteImag= c1.parteImag;
    }
    
    //Getters
    public float getParteReal() {
        return parteReal;
    }
    public float getParteImag() {
        return parteImag;
    }
    
    //Setters
    public void setParteReal(float parteReal) {
        this.parteReal = parteReal;
    }
    public void setParteImag(float parteImag) {
        this.parteImag = parteImag;
    }
    
    //Metodos    
    public Complejo suma(Complejo num1){
        return new Complejo(this.parteReal + num1.parteReal, this.parteImag + num1.parteImag);  
    }
    public Complejo resta(Complejo num1){
        return new Complejo(this.parteReal - num1.parteReal, this.parteImag - num1.parteImag);
    }
    public Complejo conjugada(){
        return new Complejo(this.parteReal, -(this.parteImag));
    }
    public Complejo multiplicacion(Complejo num1){
        return new Complejo((this.parteReal*num1.parteReal)-(this.parteImag*num1.parteImag), (this.parteReal*num1.parteImag)+(this.parteImag*num1.parteReal));
    }
    public Complejo division(Complejo num1){
        Complejo dividendo = this.multiplicacion(num1.conjugada());
        return new Complejo(dividendo.parteReal/(num1.multiplicacion(num1.conjugada()).parteReal), dividendo.parteImag/(num1.multiplicacion(num1.conjugada()).parteReal));
    }
    public double norma(){
        double rtaNorma= Math.sqrt((this.getParteReal()*this.getParteReal())+(this.getParteImag()*this.getParteImag()));
        return rtaNorma;
    }
    
}
