package ui;

import domain.DomainException;
import domain.Shop;

import javax.swing.*;

public class Appeke {
    static Shop shop = new Shop();

    public static void main(String[] args) throws DomainException {
        try {
            String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
            int choice = -1;
            while (choice != 0) {
                String choiceString = JOptionPane.showInputDialog(menu);
                if (choiceString == null || choiceString.isEmpty()) {
                    continue;
                }
                try {
                    choice = Integer.parseInt(choiceString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid menu choice: \"" + choiceString + "\", try again.");
                    continue;
                }
                if (choice == 1) {
                    addProductUi();
                } else if (choice == 2) {
                    shop.showProduct();
                } else if (choice == 3) {
                    shop.showPrice();
                }
            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void addProductUi() throws DomainException {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");
        shop.addProduct(title, id, type);
    }
}
