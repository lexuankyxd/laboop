import java.util.Scanner;

public class CustomerUser {
  private Scanner console = AimsSystem.sc;
  String addr;
  String email;
  String pnumber;
  String name;
  Order order = null;
  Boolean informationAdded = false;
  Cart cart = new Cart();
  public void addShipingInformation(){
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

  public void placeOrder(){
    if(!informationAdded)addShipingInformation();
    if(cart.itemsOrdered.size() >= 1) {
      order = new Order(this, 0);
      AimsSystem.unprocessedOrder.add(order);
    }
  }

  public void payForOrder(){
    if(order != null) {
      if(!order.status) {
        System.out.println("Order not yet accepted, wait for admin to accept");
        return;
      }
      System.out.println("Enter payment info");
      String pi = console.nextLine();

      Transaction t = new Transaction(pi, 0, order.totalCost, order);
      AimsSystem.unprocessedTransactions.add(t);
    }
  }
}
