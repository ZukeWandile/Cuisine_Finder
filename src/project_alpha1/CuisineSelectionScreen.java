/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project_alpha1;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CuisineSelectionScreen extends JFrame implements ActionListener {

    JComboBox<String> cuisineDropdown;
    JButton submitButton;
    JLabel label;
    RecipeBook recipeBook;  // Reference to the RecipeBook

    public CuisineSelectionScreen() {
        super("Select Cuisine");

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label
        label = new JLabel("Select a cuisine:");

        // Create a drop-down box with the cuisines
        String[] cuisines = {"Italian", "Spanish", "South African"};
        cuisineDropdown = new JComboBox<>(cuisines);

        // Create a button to submit the selection
        submitButton = new JButton("Show Recipes");
        submitButton.addActionListener(this);

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(label);
        add(cuisineDropdown);
        add(submitButton);

        setSize(300, 150);  // Set the size of the JFrame
        
        // Initialize the RecipeBook and load recipes
        recipeBook = new RecipeBook();
        loadRecipes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get selected cuisine
        String selectedCuisine = (String) cuisineDropdown.getSelectedItem();

        // Show the recipes for the selected cuisine
        showRecipes(selectedCuisine);
    }

    // Method to display the recipes for the selected cuisine
    private void showRecipes(String cuisineName) {
        Cuisine selectedCuisine = null;
        List<Cuisine> cuisines = recipeBook.getCuisines();

        // Find the Cuisine object by its name
        for (Cuisine cuisine : cuisines) {
            if (cuisine.getName().equalsIgnoreCase(cuisineName)) {
                selectedCuisine = cuisine;
                break;
            }
        }

        if (selectedCuisine != null) {
            List<Dish> filteredDishes = recipeBook.filterByCuisine(selectedCuisine);
            if (!filteredDishes.isEmpty()) {
                StringBuilder recipes = new StringBuilder("Dishes for " + selectedCuisine.getName() + " Cuisine:\n\n");
                for (Dish dish : filteredDishes) {
                    recipes.append("Dish: ").append(dish.getName()).append("\n")
                            .append("Description: ").append(dish.getDescription()).append("\n")
                            .append("Ingredients: \n");
                    for (String ingredient : dish.getIngredients()) {
                        recipes.append("- ").append(ingredient).append("\n");
                    }
                    recipes.append("Instructions: ").append(dish.getCookingInstructions()).append("\n\n");
                }
                // Display the dishes in a dialog box
                JOptionPane.showMessageDialog(this, recipes.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No dishes found for this cuisine.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cuisine not found.");
        }
    }

    // Method to load recipes into the RecipeBook 
    private void loadRecipes() {
        // Add cuisines
        Cuisine italianCuisine = new Cuisine("Italian", "Cuisine from Italy.");
        Cuisine spanishCuisine = new Cuisine("Spanish", "Cuisine from Spain.");
        Cuisine southAfricanCuisine = new Cuisine("South African", "Cuisine from South Africa.");

        recipeBook.addCuisine(italianCuisine);
        recipeBook.addCuisine(spanishCuisine);
        recipeBook.addCuisine(southAfricanCuisine);

        // Add dishes
        recipeBook.addDish(new Dish("Spaghetti", "Classic Italian pasta dish.", 
            new String[]{"Spaghetti", "Tomato Sauce", "Olive Oil", "Garlic", "Basil"}, 
            "Boil pasta, add sauce."));
        
        recipeBook.addDish(new Dish("Lasagna", "Layered Italian pasta with meat and cheese.", 
            new String[]{"Lasagna noodles", "Ground beef", "Tomato Sauce", "Ricotta cheese", "Mozzarella"}, 
            "Layer noodles with meat sauce and cheese, bake."));
     
        recipeBook.addDish(new Dish("Paella", "Traditional Spanish rice dish.", 
            new String[]{"Rice", "Saffron", "Chicken", "Shrimp", "Peppers"}, 
            "Cook rice, add ingredients."));
        
        recipeBook.addDish(new Dish("Tortilla Española", "Spanish omelette with potatoes and onions.", 
            new String[]{"Eggs", "Potatoes", "Onions", "Olive Oil", "Salt"}, 
            "Fry potatoes and onions, add eggs, cook until set."));
     
        recipeBook.addDish(new Dish("Bobotie", "South African curried meat dish.", 
            new String[]{"Minced Meat", "Curry Powder", "Bread", "Milk", "Eggs"}, 
            "Cook meat, mix with ingredients, bake."));
        
        recipeBook.addDish(new Dish("Bunny Chow", "South African dish of curry served in a hollowed-out loaf of bread.", 
            new String[]{"Bread", "Curry", "Chicken", "Potatoes", "Carrots"}, 
            "Cook curry, serve in hollowed-out bread."));
    }
}