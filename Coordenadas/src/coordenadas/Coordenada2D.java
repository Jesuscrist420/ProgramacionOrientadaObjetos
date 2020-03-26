/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordenadas;

/**
 *
 * @author jrqui
 */
//Clase
public class Coordenada2D extends Coordenada{
    
    // Constructores no devuelven nada 
    
    public Coordenada2D(double x, double y){
        this.setX(x);
        this.setY(y);
    }
    public Coordenada2D(){
        this.setX(0);
        this.setY(0);  
    }
    public Coordenada2D(Coordenada2D coor){
        this.setX(coor.getX());
        this.setY(coor.getY());
    }

    public double distanciaPunto(Coordenada2D coor2){
        return Math.sqrt(Math.pow((coor2.getX() - this.getX()), 2)+Math.pow((coor2.getY() - this.getY()), 2));
    }
    public double distanciaPunto(){
        return this.distanciaPunto(new Coordenada2D());
    }
    
    //Metodos
    
    public void movDiagonal(double numDiag){
       this.moverX(numDiag);
       this.moverY(numDiag);
    }
    public void movDiagonal(double numX,double numY){
       this.moverX(numX);
       this.moverY(numY);
    }
}
