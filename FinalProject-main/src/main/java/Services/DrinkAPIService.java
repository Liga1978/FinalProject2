package Services;

import Models.DrinkModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DrinkAPIService {
    private final String baseUrl;
    private JPanel mainPanel;

    public DrinkAPIService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // get Drinks by name
    public DrinkModel getDrinkByName(String name) {
        name = name.replace(" ", "_");
        try {
            URL url = new URL(
                    baseUrl + "/search.php?s=" + name //base URL given in DrinkView
            );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);

            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext())
                    inline.append(scanner.nextLine());

                scanner.close();

                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(inline.toString());

                JSONArray drinks = (JSONArray) data.get("drinks");
                List<DrinkModel> result = new ArrayList<>();

                for (Object o : drinks) {
                    JSONObject drink = (JSONObject) o;
                    List<String> ingredients = new ArrayList<>();

                    for (int i = 1; i <= 15; i++) {
                        if (drink.get("strIngredient" + i) != null)
                            ingredients.add((String) drink.get("strIngredient" + i));
                    }

                    result.add(new DrinkModel((String) drink.get("strDrink"),
                            drink.get("strAlcoholic").equals("Alcoholic"),
                            (String) drink.get("strInstructions"),
                            ingredients, (String) drink.get("strDrinkThumb")));
                }
                return result.get(0);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {

        }
        return null;
    }


    public DrinkModel getRandomCocktail() {
        try {
            URL url = new URL(
                    baseUrl + "/random.php"
            );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext())
                    inline.append(scanner.nextLine());
                scanner.close();

                JSONParser parser = new JSONParser();
                JSONObject data = (JSONObject) parser.parse(inline.toString());

                JSONArray drinks = (JSONArray) data.get("drinks");
                List<DrinkModel> result = new ArrayList<>();
                for (Object o : drinks) {
                    JSONObject drink = (JSONObject) o;
                    List<String> ingredients = new ArrayList<>();

                    for (int i = 1; i <= 15; i++) {
                        if (drink.get("strIngredient" + i) != null)
                            ingredients.add((String) drink.get("strIngredient" + i));
                    }

                    result.add(new DrinkModel((String) drink.get("strDrink"),
                            drink.get("strAlcoholic").equals("Alcoholic"),
                            (String) drink.get("strInstructions"),
                            ingredients, (String) drink.get("strDrinkThumb")));
                }
                return result.get(0);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored) {
        }
        return null;
    }
}
