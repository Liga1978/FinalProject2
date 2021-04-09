package Views;

import Controllers.DrinkController;
import Models.DBModel;
import Models.DrinkModel;
import Services.DrinkAPIService;
import Services.DrinkDBService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class DrinkView {
    private JPanel mainPanel;
    private JTextField textField1;
    private final DrinkController service;

    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JButton randomCocktailButton;
    private JButton SAVEButton;
    private JButton favoriteCocktailButton;
    private JTextField textField2;


    public JPanel getMainPanel() {
        return mainPanel;
    }



    public DrinkView() {


        String baseURL = "https://www.thecocktaildb.com/api/json/v1/1";

        DrinkAPIService drinkAPIService = new DrinkAPIService(baseURL);
        DrinkDBService drinkDBService = new DrinkDBService();
        service = new DrinkController(baseURL, drinkAPIService, drinkDBService);
       //textArea4.setText("user");



        randomCocktailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getRandomCocktail();
                //JOptionPane.showMessageDialog(mainPanel, model.getName());
                //JOptionPane.showMessageDialog(mainPanel, model.getIngredients().toString());
                //JOptionPane.showMessageDialog(mainPanel, model.getInstructions());
                textArea2.setText(model.getIngredients().toString());
                textArea3.setText(model.getInstructions());
                textField1.setText(model.getName());
            }
        });

        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel model = service.saveFavouriteDrinks(textArea4.getText(),textField1.getText());

            }
        });


        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getDrinkByName(textField1.getText());
                textArea2.setText(model.getIngredients().toString());
                textArea3.setText(model.getInstructions());
            }
        });

        favoriteCocktailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBModel model = service.showFavoriteDrinks(textArea4.getText());
                //textArea1.setText(service.showFavoriteDrinks(textArea4.getText()));
            }
        });
    }




//"strDrinkThumb" "https:\/\/www.thecocktaildb.com\/images\/media\/drink\/sxpcj71487603345.jpg"

// The plan is to have a window, with "Please type cocktail name to get a recipe", textField and "Search" button +
// another button "I'm feeling lucky" to get random cocktail and it's recipe.
// Do we also need a part where user can search for list of drinks by ingredient (for complexity of FinalProject"?
// or we can skip that initially and do it only as an extra if time allows?
}

