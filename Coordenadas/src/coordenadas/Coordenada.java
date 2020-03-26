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
public class Coordenada {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void moverX(double numX){
        this.setX(this.getX() + numX);
    }
    public void moverY(double numY){
        this.setY(this.getY() + numY);
    }
    
}
