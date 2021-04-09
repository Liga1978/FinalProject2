package Controllers;

import Models.DBModel;
import Models.DrinkModel;
import Services.DrinkAPIService;
import Services.DrinkDBService;

public class DrinkController {

    public String baseUrl;
    private final DrinkAPIService drinkAPIService;
    private final DrinkDBService drinkDBService;

    public DrinkController(String baseUrl, DrinkAPIService drinkAPIService, DrinkDBService drinkDBService) {
        this.baseUrl = baseUrl;
        this.drinkAPIService = drinkAPIService;
        this.drinkDBService = drinkDBService;
    }

    public DrinkModel getDrinkByName(String name) {
        return drinkAPIService.getDrinkByName(name);
    }

    public DrinkModel getRandomCocktail() {
        return drinkAPIService.getRandomCocktail();
    }

    public DBModel saveFavouriteDrinks(String userName, String drinkName) {
        return drinkDBService.saveFavouriteDrink(userName, drinkName);
    }

    public String showFavouriteDrinks(String userName) {
        return drinkDBService.showFavouriteDrinks(userName);
    }


    // What do we do here, if methods for getting data from API are in class DrinkAPIService?
}
