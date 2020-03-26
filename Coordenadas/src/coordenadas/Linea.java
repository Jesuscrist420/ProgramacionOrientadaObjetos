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
public class Linea extends Coordenada2D {
    
    private Coordenada2D coorInici;
    private Coordenada2D coorFinal;
    private double longitud;
    
   public Linea(Coordenada2D coorI , Coordenada2D coorF , double longit ){
        coorInici = coorI;
        coorFinal = coorF;
        longitud = longit;
    }
    
    public Linea(Linea linea1){
        coorInici = linea1.coorInici ;
        coorFinal = linea1.coorFinal;
        longitud = linea1.longitud; 
    } 

    public Coordenada2D getCoorInici() {
        return coorInici;
    }

    public void setCoorInici(Coordenada2D coorInici) {
        this.coorInici = coorInici;
    }

    public Coordenada2D getCoorFinal() {
        return coorFinal;
    }

    public void setCoorFinal(Coordenada2D coorFinal) {
        this.coorFinal = coorFinal;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public void moverLineaHorizontal(double movX){
        this.coorInici.setX(this.getX()+movX);
        this.coorFinal.setX(this.getX()+movX);
    
    }
    public void moverLineaVertical(double movY){
        this.coorInici.setY(this.getY()+movY);
        this.coorFinal.setY(this.getY()+movY);
    }
    public void moverLineaDiagonal(double movX, double movY){
        this.coorInici.setX(this.getX()+movX);
        this.coorInici.setY(this.getY()+movY);
        this.coorFinal.setX(this.getX()+movX);
        this.coorFinal.setY(this.getY()+movY);
    }    
}
