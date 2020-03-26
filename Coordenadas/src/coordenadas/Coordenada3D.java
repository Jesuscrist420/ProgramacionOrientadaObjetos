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
public class Coordenada3D extends Coordenada{
    
    private double z;
    
    //Constructores
    public Coordenada3D(Coordenada2D coor2 , double z ){
        this.z = z;
        setX(coor2.getX());
        setY(coor2.getY());
    }
    public Coordenada3D(){
        this.z = 0;     
    }
    public Coordenada3D(Coordenada3D coor3){
        setX(coor3.getX());
        setY(coor3.getY());
        this.z = coor3.z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    public void moverZ(double numZ){
        this.z = this.z + numZ;
    }
    public double distanciaPunto3D(Coordenada3D coor3){
        return Math.sqrt((coor3.getX() - this.getX()) + (coor3.getX() - this.getY()) + (coor3.z - this.z));
    }
    public double distanciaPunto3D(){
        return this.distanciaPunto3D(new Coordenada3D());
    }
    
    public void movDiagonal3D(double numDiag){
       this.moverX(numDiag);
       this.moverY(numDiag);
       this.moverZ(numDiag);
       
    }
    public void movDiagonal3D(double numX , double numY , double numZ){
       this.moverX(numX);
       this.moverY(numY);
       this.moverZ(numZ);
    }    
}
