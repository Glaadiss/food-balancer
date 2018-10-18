package views;

import controllers.Home;
import models.Food;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * FoodBalancer's view in command line
 *
 * @author bartlomiejgladys
 */
public class CommandLineInterface {
    /**
     * Pattern for table width
     */
    private static final String ROW_FORMAT = "%10s%32s%10s\n";

    /**
     * User's passing text by scanner
     */
    final Scanner scanner = new Scanner(System.in);

    /**
     * Display the first information for user.
     */
    public void showStartMessage() {
        System.out.println("Hello, this is your Food Balancer application!");
    }

    /**
     * Display question to users about new food
     *
     * @param home Home object used to call callback on.
     */
    public void showNewFoodView(Home home) {
        System.out.print("Enter name of the new food (max 15 signs): ");
        String name = scanner.next();
        System.out.println("Now enter the short description (max 50 signs): ");
        String description = scanner.next();
        System.out.println("Quality of the food (Number between 1 and 10): ");
        String quality = scanner.next();
        home.newFoodCallback(name, description, quality);
    }

    /**
     * Display food's table's row
     *
     * @param name        Food's name
     * @param description Food's description
     * @param quality     Food's quality
     */
    private void displayRow(String name, String description, String quality) {
        System.out.format(ROW_FORMAT, name, description, quality);
    }

    /**
     * Display food's table's row
     *
     * @param name        Food's name
     * @param description Food's description
     * @param quality     Food's quality
     */
    private void displayRow(String name, String description, int quality) {
        System.out.format(ROW_FORMAT, name, description, String.valueOf(quality));
    }

    /**
     * Display food's table
     *
     * @param foods Container for foods
     * @param home  Controller object to put callback on
     */
    public void showFoodList(ArrayList<Food> foods, Home home) {
        System.out.println("Food list");
        displayRow("Name", "Description", "Quality");
        foods.forEach(el -> displayRow(el.getName(), el.getDescription(), el.getQuality()));
        this.handleUserChoice(home);
    }

    /**
     * Display choice prompt for user
     *
     * @param home  Controller object to put callback on
     */
    public void handleUserChoice(Home home) {
        System.out.println("Add food: press 1        Food list: press 2");
        String choice = scanner.next();
        home.userChoiceCallback(choice);
    }

    /**
     * Show success message after food creation.
     *
     * @param food New food object.
     * @param home Controller object to put callback on.
     */
    public void showSuccessMessage(Food food, Home home) {
        System.out.println("You've added food with name " + food.getName());
        this.handleUserChoice(home);
    }

    /**
     * Show failure message after food creation.
     *
     * @param err error message.
     * @param home Controller object to put callback on.
     */
    public void showFailureMessage(String err, Home home) {
        System.out.println("You haven't added food, reason: " + err);
        this.handleUserChoice(home);
    }

    /**
     * Show failure message after user's choice.
     *
     * @param err error message.
     * @param home Controller object to put callback on.
     */
    public void showFailureChoiceMessage(String err, Home home) {
        System.out.println("You've checked wrong number " + err);
        this.handleUserChoice(home);
    }

}
