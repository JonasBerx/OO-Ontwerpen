package domain;

import java.util.ArrayList;

import javax.swing.JOptionPane;

// tekst
public class Shop {

    private ArrayList<Product> products;

    public Shop()
    {
        products = new ArrayList<Product>();
    }

    public double getPrice(Product product, int days) {
        double price = 0;
        if (product instanceof Movie) {
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0) {
                price += (daysLeft * 2);
            }
        } else if(product instanceof Game){
            price = days * 3;
        }
        return price;
    }

    public static void main(String[] args) throws Exception {
        Shop shop = new Shop();

        String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3){
                showPrice(shop);
            }
        }
    }

    public static void addProduct(Shop shop) throws Exception {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        Product product = null;
        if (type.equals("M")) {
            product = new Movie(title, id);
        } else if (type.equals("G")) {
            product = new Game(title, id);
        } else {
            // TODO: Panic
            throw new Exception("AAAAAAAh");
        }

        shop.products.add(product);
    }

    private Product getProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for(int i = 0; i < shop.products.size() && !found; i++)
        {
            if(shop.products.get(i).getId().equals(id))
            {
                idx = i;
                found = true;
            }
        }

        if (found) {
            return shop.products.get(idx);
        } else {
            return null;
        }
    }

    public static void showProduct(Shop shop) {
        Product product = shop.getProduct(shop);
        if(product != null)
        {
            JOptionPane.showMessageDialog(null, product.getTitle());
        }
    }

    public static void showPrice(Shop shop){
        Product product = shop.getProduct(shop);
        if(product != null)
        {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.getPrice(product, days));
        }
    }
}