package utils;

import static utils.Validator.validateNumber;
import static utils.Validator.validateText;

/**
 * Validator for user's input during food creation
 *
 * @author bartlomiejgladys
 * @version 1.0
 */
public class FoodValidator {

    /**
     * error message passed to user after action
     */
    private String errorMessage;

    /**
     * Method, which checks out user's input
     *
     * @param name        food's name
     * @param description food's description
     * @param quality     food's quality
     */
    public FoodValidator(String name, String description, String quality) {
        try {
            validateText("Name", name, 15);
            validateText("Description", description, 50);
            validateNumber("Quality", quality, 1, 10);
        } catch (NumberInputException | TextInputException err) {
            errorMessage = err.getMessage();
        }
    }

    /**
     * Converts object's state to the text form
     *
     * @return errorMessage or null if there is no error
     */
    @Override
    public String toString() {
        return errorMessage;
    }
}
