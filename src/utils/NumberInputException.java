package utils;

/**
 * Exception class for objects thrown when user pass wrong input-number
 *
 * @author bartlomiejgladys
 */
public class NumberInputException extends Exception{

    /**
     * Constructor
     *
     * @param message display message
     */
    public NumberInputException(String message){
        super(message);
    }
}
