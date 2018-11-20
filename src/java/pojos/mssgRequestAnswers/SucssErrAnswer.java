/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos.mssgRequestAnswers;

/**
 *
 * @author kalav
 */
public class SucssErrAnswer {
    public Boolean error;
    public String mensaje;

    public SucssErrAnswer() {
    }

    public SucssErrAnswer(Boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }
    
    
}
