/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_alpha1;

/**
 *
 * @author wzuke
 */
public class Dish {
     private String name;
    private String description;
    private String[] ingredients;
    private String cookingInstructions;

    
    // Constructor to initialize a Dish object
    public Dish(String name, String description, String[] ingredients, String cookingInstructions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.cookingInstructions = cookingInstructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingInstructions() {
        return cookingInstructions;
    }

    public void setCookingInstructions(String cookingInstructions) {
        this.cookingInstructions = cookingInstructions;
    }
}

