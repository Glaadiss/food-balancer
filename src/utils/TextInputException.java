package utils;

/**
 * Exception class for objects thrown when user pass wrong input-text
 *
 * @author bartlomiejgladys
 * @version 1.0
 */
public class TextInputException extends Exception {

    /**
     * Constructor
     *
     * @param message display message
     */
    public TextInputException(String message){
        super(message);
    }
}
