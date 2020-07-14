/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author DERA
 */
public class VerificationException extends Exception {

    /**
     * Creates a new instance of <code>VerificationException</code> without
     * detail message.
     */
    public VerificationException() {
    }

    /**
     * Constructs an instance of <code>VerificationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VerificationException(String msg) {
        super(msg);
    }
}
