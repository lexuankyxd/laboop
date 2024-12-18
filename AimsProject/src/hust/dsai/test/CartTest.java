package hust.dsai.test;

import hust.dsai.aims.cart.Cart;
import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.screen.CartScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;

public class CartTest {


  public static void main(String[] args) {
    CustomerUser user = new CustomerUser();
    // Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd0 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    user.cart.addMedia(dvd0);
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    user.cart.addMedia(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    user.cart.addMedia(dvd2);
    // Test the print method

  }
}
