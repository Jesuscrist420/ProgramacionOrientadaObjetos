/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodados;

/**
 *
 * @author jrqui
 */
public class Dado {
    public int cara;

    public int getCara() {
        return cara;
    }

    public void setCara(int cara) {
        this.cara = cara;
    }
    
    
    
    public Dado(){
       this.lanzar();
    }
    
    public void lanzar(){
        this.cara = (int)(Math.random()*6)+1;
    }
    
}
