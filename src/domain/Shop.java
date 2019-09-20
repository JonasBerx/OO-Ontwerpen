package domain;

import javax.swing.*;
import java.util.ArrayList;

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


    public void addProduct(String title, String id, String type) throws DomainException {
        Product product = null;
        if (type.equals("M")) {
            product = new Movie(title, id);
        } else if (type.equals("G")) {
            product = new Game(title, id);
        } else {
            // TODO: Panic
            throw new DomainException("Fucking Normies REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        }
        this.products.add(product);
    }

    private Product getProduct() {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < this.products.size() && !found; i++)
        {
            if (this.products.get(i).getId().equals(id))
            {
                idx = i;
                found = true;
            }
        }

        if (found) {
            return this.products.get(idx);
        } else {
            return null;
        }
    }

    public void showProduct() {
        Product product = this.getProduct();
        if(product != null)
        {
            JOptionPane.showMessageDialog(null, product.getTitle());
        }
    }

    public void showPrice() {
        Product product = this.getProduct();
        if(product != null)
        {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, this.getPrice(product, days));
        }
    }
}