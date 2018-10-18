package utils;

/**
 * Exception class for objects thrown when user pass wrong input-text
 *
 * @author bartlomiejgladys
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
