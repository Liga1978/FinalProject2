package Views;

import Models.DrinkModel;
import Services.DrinkAPIService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinkView {
    private JPanel mainPanel;
   private JTextField textField1;
    private JRadioButton nonAlcoholic;
    private JButton button1;
    private JCheckBox alcoholicCheckBox;
    private JCheckBox nonAlcoholicCheckBox;
    private JButton button2;
    private DrinkAPIService service;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public DrinkView() {
        service = new DrinkAPIService("https://www.thecocktaildb.com/api/json/v1/1");
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getDrinkByName(textField1.getName());
                JOptionPane.showMessageDialog(mainPanel,model.getRecipe());


            //DrinkModel model = controller.getDrinkByName(textField1.getText());
                //                JOptionPane.showMessageDialog(mainPanel,model.getIngredients().toString());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrinkModel model = service.getRandomCocktail();
                JOptionPane.showMessageDialog(mainPanel,model.getName());
            }
        });
    }



// The plan is to have a window, with "Please type cocktail name to get a recipe", textField and "Search" button +
// another button "I'm feeling lucky" to get random cocktail and it's recipe.
// Do we also need a part where user can search for list of drinks by ingredient (for complexity of FinalProject"?
// or we can skip that initially and do it only as an extra if time allows?
}

