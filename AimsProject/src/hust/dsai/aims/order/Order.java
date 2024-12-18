package hust.dsai.aims.order;

import hust.dsai.aims.AimsSystem;
import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
  public CustomerUser user;
  int ord_id;
  ArrayList<Media> items = new ArrayList<>();
  public boolean status;
  float shippingCost;
  public double totalCost;
  private static int idcnt;

  public Order(CustomerUser user, List<Media> items) throws Exception {
    this.items.addAll(items);
    this.user = user;
    this.ord_id = idcnt++;
    this.status = false;
    this.shippingCost = 1f;
    totalCost = user.cart.total * 1.1 + shippingCost;
  }

  public void printOrder() {
    System.out.println(ord_id + " status: " + status + " shippingCost: " + shippingCost + " totalCost: " + totalCost);
  }

  public void updateStatus(boolean b) {
    status = b;
  }
}
