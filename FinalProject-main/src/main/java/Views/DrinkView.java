package Views;

import Controllers.DrinkController;
import Models.DBModel;
import Models.DrinkModel;
import Services.DrinkAPIService;
import Services.DrinkDBService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkView {
    private JPanel mainPanel;
    private JTextField textField1;
    private final DrinkController controller;

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
        controller = new DrinkController(baseURL, drinkAPIService, drinkDBService);
        //textArea4.setText("user");

        randomCocktailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = controller.getRandomCocktail();
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
                DBModel model = controller.saveFavouriteDrinks(textField2.getText(), textField1.getText());
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = controller.getDrinkByName(textField1.getText());
                if (model != null) {
                    textArea2.setText(model.getIngredients().toString());
                    textArea3.setText(model.getInstructions());
                } else{
                    JOptionPane.showMessageDialog(mainPanel, "Error to find cocktail");
                }

            }
        });

        favoriteCocktailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea4.setText(controller.showFavouriteDrinks(textField2.getText()));
            }
        });
    }
}

