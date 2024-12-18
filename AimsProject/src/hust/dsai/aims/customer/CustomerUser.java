package hust.dsai.aims.customer;

import hust.dsai.aims.AimsSystem;
import hust.dsai.aims.order.Order;
import hust.dsai.aims.transaction.Transaction;
import hust.dsai.aims.cart.Cart;

import java.util.ArrayList;
import java.util.Scanner;
public class CustomerUser {
  private Scanner console = AimsSystem.sc;
  String addr;
  String email;
  String pnumber;
  String name;
  ArrayList<Order> orders = new ArrayList<>();
  Boolean informationAdded = false;
  public Cart cart = new Cart();

  public void addShipingInformation() {
    System.out.println("address: ");
    addr = console.nextLine();
    System.out.println("email: ");
    email = console.next();
    System.out.println("pnumber: ");
    pnumber = console.next();
    System.out.println("name: ");
    String name = console.nextLine();
    informationAdded = true;
  }

  public void placeOrder() {
    if (!informationAdded)
      //addShipingInformation();
      // TODO shipping info shit
    if (!cart.itemsOrdered.isEmpty()) {
      try {
        orders.add(new Order(this, this.cart.itemsOrdered.stream().toList()));
        AimsSystem.unprocessedOrder.add(orders.getLast());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void payForOrder(Order order) {
    if (order != null) {
      if (!order.status) {
        System.out.println("hust.dsai.aims.order.Order not yet accepted, wait for admin to accept");
        return;
      }
      System.out.println("Enter payment info");
      String pi = console.nextLine();

      Transaction t = new Transaction(pi, 0, order.totalCost, order);
      AimsSystem.unprocessedTransactions.add(t);
    }
  }
}
