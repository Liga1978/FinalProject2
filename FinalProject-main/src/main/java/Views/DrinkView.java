package Views;

import Controllers.DrinkController;
import Models.DrinkModel;
import Services.DrinkAPIService;
import Services.DrinkDBService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class DrinkView {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton button2;
    private JTextField ingredientsTextField;
    private JTextField recepieTextField2;
    //private DrinkAPIService service;
    private final DrinkController service;


    public JPanel getMainPanel() {
        return mainPanel;
    }



    public DrinkView() {


        String baseURL = "https://www.thecocktaildb.com/api/json/v1/1";
        DrinkAPIService drinkAPIService = new DrinkAPIService(baseURL);
        DrinkDBService drinkDBService = new DrinkDBService();
        service = new DrinkController(baseURL, drinkAPIService, drinkDBService);
        //service = new DrinkAPIService("https://www.thecocktaildb.com/api/json/v1/1");

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getDrinkByName(textField1.getText());
                //JOptionPane.showMessageDialog(mainPanel, model.getIngredients().toString());
                //JOptionPane.showMessageDialog(mainPanel, model.getInstructions());
                  ingredientsTextField.setText(model.getIngredients().toString());
                  recepieTextField2.setText(model.getInstructions());

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getRandomCocktail();
                //JOptionPane.showMessageDialog(mainPanel, model.getName());
                //JOptionPane.showMessageDialog(mainPanel, model.getIngredients().toString());
                //JOptionPane.showMessageDialog(mainPanel, model.getInstructions());
                ingredientsTextField.setText(model.getIngredients().toString());
                recepieTextField2.setText(model.getInstructions());
                textField1.setText(model.getName());
            }
        });

        ingredientsTextField.addComponentListener(new ComponentAdapter() {
        });
    }


//"strDrinkThumb" "https:\/\/www.thecocktaildb.com\/images\/media\/drink\/sxpcj71487603345.jpg"

// The plan is to have a window, with "Please type cocktail name to get a recipe", textField and "Search" button +
// another button "I'm feeling lucky" to get random cocktail and it's recipe.
// Do we also need a part where user can search for list of drinks by ingredient (for complexity of FinalProject"?
// or we can skip that initially and do it only as an extra if time allows?
}

