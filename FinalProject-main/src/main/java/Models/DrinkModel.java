package Models;

import java.util.List;

public class DrinkModel {
    private String name;
    private boolean alcoholic;
    private String instructions;
    private List<String> ingredients;

    public DrinkModel(String name, boolean alcoholic, String instructions, List<String> ingredients) {
        this.name = name;
        this.alcoholic = alcoholic;
        this.instructions = instructions;
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

}
