package hust.dsai.aims.order;

import hust.dsai.aims.AimsSystem;
import hust.dsai.aims.customer.CustomerUser;

public class Order {
  public CustomerUser user;
  int ord_id;
  public boolean status;
  float shippingCost;
  public float totalCost;

  public Order(CustomerUser user, int id) {
    this.user = user;
    this.ord_id = id;
    this.status = false;
    this.shippingCost = AimsSystem.calculateShippingCost(this);
    totalCost = user.cart.total * 1.1f + shippingCost;
  }

  public void printOrder() {
    System.out.println(ord_id + " status: " + status + " shippingCost: " + shippingCost + " totalCost: " + totalCost);
  }

  public void updateStatus(boolean b) {
    status = b;
  }
}
