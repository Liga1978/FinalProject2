import Views.DrinkView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("GuiMain");
        //adds to Jframe main panel
        frame.setContentPane(new DrinkView().getMainPanel());
        //set default operation when closing panel
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Changes the window size to show every element
        frame.pack();
        //make frame visible
        frame.setVisible(true);
        //setting frame size as too small initially was
        frame.setSize(500, 500);

        }
}