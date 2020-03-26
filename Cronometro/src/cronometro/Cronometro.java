/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronometro;



/**
 *
 * @author Estudiantes
 */
public class Cronometro {

    private Horario horario;
    private Minutero minutero;
    private Secundero secundero;
    private int estado;

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Minutero getMinutero() {
        return minutero;
    }

    public void setMinutero(Minutero minutero) {
        this.minutero = minutero;
    }

    public Secundero getSecundero() {
        return secundero;
    }

    public void setSecundero(Secundero secundero) {
        this.secundero = secundero;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    public Cronometro(){
        this.estado = 0 ;
        this.horario= new Horario();
        this.minutero = new Minutero();
        this.secundero = new Secundero();
    }
    
    public void tick(){
        this.secundero.mover();
        if(this.secundero.getValorVariable()== 0){
            this.minutero.mover();
            if(this.minutero.getValorVariable() == 0){
                this.horario.mover();                      
            }
        }
    }
    
    public void iniciar(){
        this.estado = 1;
        
    }
    public void pausar(){
        this.estado = 2;
        
    } 
    public void detener(){
        this.estado = 0;  
    }

}
