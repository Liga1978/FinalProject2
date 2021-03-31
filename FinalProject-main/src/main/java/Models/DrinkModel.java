package Models;

import java.util.List;

public class DrinkModel {
    private String name;
    private boolean alcoholic;
    private String recipe;
    private List<String> ingredients;

    public DrinkModel(String name, boolean alcoholic, String recepie, List<String> ingredients) {
        this.name = name;
        this.alcoholic = alcoholic;
        this.recipe = recepie;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

}
