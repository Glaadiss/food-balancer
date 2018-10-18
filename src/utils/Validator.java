package utils;

/**
 *  Stateless Validator with static methods
 *
 * @author bartlomiejgladys
 */
public class Validator {
    /** 
     * Check user's text input
     * 
     * @param fieldName Name of the Input
     * @param text Text to valid
     * @param length max valid length
     * @throws utils.TextInputException throws when users passes wrong text
     */
    public static void validateText(String fieldName, String text, int length) throws TextInputException{
        int currentLength = text.length();
        if(currentLength > length){
            String message = fieldName + " is to long by " + String.valueOf(currentLength - length + "!");
            throw new TextInputException(message) ;
        }
        if(currentLength == 0){
            throw new TextInputException("You have to pass " + fieldName + "!" );
        }
        if(fieldName.equals("Name") && !text.matches("\\D+")){
            throw new TextInputException("Name can't include digits!");
        }
    }
    
    /** 
     * Check user's number input
     * 
     * @param fieldName Name of the Input
     * @param value Number to valid
     * @param from bottom range of value
     * @param to Top range of value
     * @throws utils.NumberInputException throws when user passes wrong number
     */
    public static void validateNumber(String fieldName, String value, int from, int to) throws NumberInputException{
        int numberValue;
        try{
             numberValue = Integer.parseInt(value.trim());
        }
        catch(NumberFormatException err){
            throw new NumberInputException(fieldName + " has to be numeric!");
        }
        if(numberValue < from ){
            throw new NumberInputException(fieldName + " is too small!");
        }
        if(numberValue > to){
            throw new NumberInputException(fieldName + " is too big!");            
        }
    }
}
