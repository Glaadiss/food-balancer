package models;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Repo model - communicate between controllers and other models
 *
 * @author bartlomiejgladys
 * @version 1.0
 */
public class Repo {

    /**
     * Food's collection
     */
    private ArrayList<Food> foods = new ArrayList<>();

    /**
     * Consumer for callback in getFoods method
     */
    public Consumer<Food> consumer;
    
    /** 
     * Add food to list
     * 
     * @param food food to add
     * @return added food object;
     */
    public Food addFood(Food food){
        foods.add(food);
        return food;
    }
    
    /** 
     * Remove food from the list
     * 
     * @param food object to remove from the list
     * @return removed food object;
     */
    public Food deleteFood(Food food){
        foods.remove(food);
        return food;
    }
    
    /** 
     * Returns all foods;
     * 
     * @return list of foods;
     */
    public ArrayList<Food> getFoods(){
        return foods;
    }
    
    /** 
     * Give access to food's list by high order function
     * 
     * @param func Function, which has access to food's list
     */    
    public void getFoods(Consumer<Food> func){
        foods.forEach(func);
    }
     
}
