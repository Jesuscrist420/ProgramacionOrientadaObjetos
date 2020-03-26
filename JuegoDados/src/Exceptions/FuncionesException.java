/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import Exceptions.ApuestaVaciaException;

/**
 *
 * @author jrqui
 */
public class FuncionesException {
   public static Integer numNeg(String b) throws NegativeException{
        int numero = Integer.parseInt(b);
        if(numero<0){
            throw new NegativeException("negativo");
        }
        return numero;
    } 
   public static Boolean verificarApuesta(String apuesta) throws ApuestaVaciaException, NegativeException{
       int numeroApuesta = Integer.parseInt(apuesta);
       if(numeroApuesta == 0){
           throw new ApuestaVaciaException("Apuesta vacia");
       }
       else if(numeroApuesta < 0){
           throw new NegativeException("negativo");
       }
       return true;
   }
   public static Boolean regVacio(String usuario, String nombre, String password, String saldo) throws RegistroVacioException{
       if(usuario.equals("") && nombre.equals("") && password.equals("") && saldo.equals("")){
           throw new RegistroVacioException("Registro vacio");
       }
       
       return true;
       
   }
}
