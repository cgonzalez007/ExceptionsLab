/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 *
 * @author cgonz
 */
public class InvalidFullNameInputException extends IllegalArgumentException {
    
    public InvalidFullNameInputException() {
    }

    public InvalidFullNameInputException(String s) {
        super(s);
    }

    public InvalidFullNameInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFullNameInputException(Throwable cause) {
        super(cause);
    }
    
}
