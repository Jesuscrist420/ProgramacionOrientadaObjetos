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
public class Coordenadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Coordenada2D prueba = new Coordenada2D(1,2);
        System.out.println(prueba.distanciaPunto(new Coordenada2D(1,5)));
        System.out.println(prueba.distanciaPunto());
        prueba.moverX(3);
        prueba.moverY(5);
        System.out.println(prueba.distanciaPunto());   
    }
}
