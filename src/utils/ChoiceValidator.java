package utils;

import static utils.Validator.validateNumber;

/**
 * Validator for user's action
 *
 * @author bartlomiejgladys
 */
public class ChoiceValidator{

    /**
     * error message passed to user after action
     */
    private String errorMessage;
    
    /** 
     * Method, which checks out user's input
     * 
     * @param choice user's choice to handle further action
     */
    public ChoiceValidator(String choice){
        try{           
            validateNumber("Choice", choice, 1, 2);
        }        
        catch(NumberInputException err){
            errorMessage = err.getMessage();
        }
    }

    /**
     * Converts object's state to the text form
     * @return errorMessage or null if there is no error
     */
    @Override
    public String toString(){
        return errorMessage;
    }
}
