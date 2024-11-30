package hust.dsai.aims.admin;

import hust.dsai.aims.AimsSystem;
import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.order.Order;

import java.util.Scanner;

public class AdminUser {
  String username, password;
  Scanner sc = AimsSystem.sc;

  public void login(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public void viewOrders() {
    for (Order o : AimsSystem.unprocessedOrder)
      o.printOrder();
  }

  public void responseOrder(Order o) {
    System.out.println("Accept(1) or reject order(0):");
    int choice = sc.nextInt();
    o.status = choice == 1;
    AimsSystem.processedOrder.add(o);
  }

  public void addItem() {
    DigitalVideoDisc item = new DigitalVideoDisc();
    System.out.println("Enter dvd title: ");
    item.setTitle(sc.nextLine());
    System.out.println("Enter dvd category: ");
    item.setCategory(sc.nextLine());
    System.out.println("Enter dvd director: ");
    item.setDirector(sc.nextLine());
    System.out.println("Enter dvd cost: ");
    item.setCost(sc.nextFloat());
    System.out.println("Enter dvd length: ");
    item.setLength(sc.nextInt());
    AimsSystem.dvdCollection.add(item);
  }

  public void removeItem(DigitalVideoDisc item) {
    AimsSystem.dvdCollection.remove(item);
  }

  public void logout() {
    System.out.println("Admin logged out!");
  }

}
