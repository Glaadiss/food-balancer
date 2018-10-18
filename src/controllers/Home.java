package controllers;

import models.Food;
import models.Repo;
import utils.ChoiceValidator;
import utils.FoodValidator;
import views.CommandLineInterface;

/**
 * Main controller - handle first user's view
 *
 * @author bartlomiejgladys
 * @version 1.0
 */
public class Home {

    private final CommandLineInterface view = new CommandLineInterface();
    private final Repo repo = new Repo();

    @SuppressWarnings("LeakingThisInConstructor")
    public Home() {
        view.showStartMessage();
        view.handleUserChoice(this);
    }

    /**
     * Display view for food's creation.
     */
    public void newFoodAction() {
        view.showNewFoodView(this);
    }

    /**
     * Callback after food's creation
     *
     * @param name        food's name
     * @param description food's description
     * @param quality     food's quality
     */
    public void newFoodCallback(String name, String description, String quality) {
        FoodValidator validator = new FoodValidator(name, description, quality);
        String err = String.valueOf(validator);
        if (err == null) {
            Food food = new Food(name, description, Integer.parseInt(quality));
            repo.addFood(food);
            view.showSuccessMessage(food, this);
        } else {
            view.showFailureMessage(err, this);
        }
    }

    /**
     * Handle user's action-response and choose the next action
     *
     * @param choice user's choice
     */
    public void userChoiceCallback(String choice) {
        ChoiceValidator validator = new ChoiceValidator(choice);
        String err = String.valueOf(validator);
        if (err == null) {
            redirectView(choice);
        } else {
            view.showFailureChoiceMessage(err, this);
        }

    }

    /**
     * Redirect user's view based on his choice
     *
     * @param choice user's choice
     */
    private void redirectView(String choice) {
        if (choice.contains("1")) {
            view.showNewFoodView(this);
        } else if (choice.contains("2")) {
            view.showFoodList(repo.getFoods(), this);
        }
    }

}
