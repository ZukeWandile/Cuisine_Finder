/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_alpha1;

import project_alpha1.Cuisine;
import project_alpha1.Dish;
import java.util.ArrayList;
import java.util.List;

public class RecipeBook {

    // List to store all the cuisines
    private List<Cuisine> cuisines = new ArrayList<>();
    // List to store all the dishes
    private List<Dish> dishes = new ArrayList<>();

    // Adds a new cuisine to the RecipeBook
    public void addCuisine(Cuisine cuisine) {
        cuisines.add(cuisine);
    }

    // Adds a new dish to the RecipeBook
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    // Returns the list of all cuisines in the RecipeBook
    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    // Returns the list of all dishes in the RecipeBook
    public List<Dish> getDishes() {
        return dishes;
    }

    // Searches for dishes that match a keyword in the name or description
    public List<Dish> searchDishes(String keyword) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : dishes) {
            // Check if the dish's name or description contains the keyword
            if (dish.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                dish.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(dish);
            }
        }
        return result;
    }

    // Filters dishes based on the selected cuisine
    public List<Dish> filterByCuisine(Cuisine cuisine) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : dishes) {
            // Check if the dish's description contains the cuisine name
            if (dish.getDescription().toLowerCase().contains(cuisine.getName().toLowerCase())) {
                result.add(dish);
            }
        }
        return result;
    }

    // Filters dishes based on the selected meat type (chicken or beef)
    public List<Dish> filterByMeatType(String meatType) {
        List<Dish> result = new ArrayList<>();
        for (Dish dish : dishes) {
            // Check if the dish's ingredients contain the selected meat type
            for (String ingredient : dish.getIngredients()) {
                if (ingredient.toLowerCase().contains(meatType.toLowerCase())) {
                    result.add(dish);
                    break;
                }
            }
        }
        return result;
    }
}