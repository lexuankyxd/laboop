package hust.dsai.aims;

import hust.dsai.aims.admin.AdminUser;
import hust.dsai.aims.customer.CustomerUser;
import hust.dsai.aims.media.*;
import hust.dsai.aims.order.Order;
import hust.dsai.aims.store.Store;
import hust.dsai.aims.transaction.Transaction;

import java.util.*;

public class AimsSystem {
  public static Store store = new Store();
  public static List<Order> unprocessedOrder = new ArrayList<>();
  public static List<Order> processedOrder = new ArrayList<>();
  public static List<Transaction> unprocessedTransactions = new ArrayList<>();
  public static List<Transaction> processedTransactions = new ArrayList<>();
  public static Random rand = new Random();
  public static Scanner sc = new Scanner(System.in);

  public static float calculateShippingCost(Order o) {
    return 1.22f;
  }

  public static void pickToDiscount(Order o) {
    int i = rand.nextInt() % (o.user.cart.itemsOrdered.size());
    o.user.cart.totalCost();
    o.user.cart.total -= o.user.cart.itemsOrdered.get(i).getCost();
  }

  public static void sendTransactionReq(Transaction t) {
    t.updateStatus(true);
  }

  public static void sortCollection() {
    int m;
    System.out.println("Enter input mode(1 for by title, 2 for category, 3 for cost): ");
    m = sc.nextInt();
    switch (m) {
      case 1:
        store.itemsInStore.sort(new Comparator<>() {
            @Override
            public int compare(Media d1, Media d2) {
                return d1.getTitle().compareTo(d2.getTitle());
            }
        });
        break;

      case 2:
        store.itemsInStore.sort(new Comparator<>() {
            @Override
            public int compare(Media d1, Media d2) {
                return d1.getCategory().compareTo(d2.getCategory());
            }
        });
        break;
      default:
        store.itemsInStore.sort(new Comparator<>() {
            @Override
            public int compare(Media d1, Media d2) {
                if (d1.getCost() < d2.getCost())
                    return -1;
                return d1.getCost() > d2.getCost() ? 1 : 0;
            }
        });
    }
  }

  private static boolean checkIfListContains(ArrayList<String> arr, String s) {
    for (String str : arr)
      if (s.contains(str))
        return true;
    return false;
  }

  public static List<Media> searchInCollection() {
    List<Media> res = new ArrayList<>();
    int m;
    System.out.println("Enter search mode(1 for title, 2 for category, 3 for cost range): ");
    m = sc.nextInt();
    int t = 0;
    float c1 = 0, c2 = 0;
    ArrayList<String> keywords = new ArrayList<>();
    if (m != 3) {
      System.out.println("Enter amount of keywords and a list of keywords seperated by space: ");
      t = sc.nextInt();
      for (int i = 0; i < t; i++)
        keywords.add(sc.next());
    } else {
      System.out.println("Enter range of price: ");
      c1 = sc.nextFloat();
      c2 = sc.nextFloat();
    }
    switch (m) {
      case 1:
        for (Media item : store.itemsInStore) {
          if (checkIfListContains(keywords, item.getTitle())) {
            res.add(item);
          }
        }
        break;
      case 2:
        for (Media item : store.itemsInStore) {
          if (checkIfListContains(keywords, item.getCategory())) {
            res.add(item);
          }
        }
        break;
      default:
        for (Media item : store.itemsInStore) {
          if (c1 <= item.getCost() && item.getCost() <= c2)
            res.add(item);
        }
    }
    return res;
  }

  public static void main(String[] args) {
    while (true) {
      System.out.println("Are you a user(0) or admin(1) or 2 to exit: ");
      int m = sc.nextInt();
      sc.nextLine();
      boolean b = false;
      if (m == 2)
        return;
      if (m == 1) {
        AdminUser admin = new AdminUser();
        System.out.println("Username: ");
        String username = sc.next();
        System.out.println("Password: ");
        String password = sc.next();
        admin.login(username, password);
        while (true) {
          System.out.println("1) View orders");
          System.out.println("2) Accept or reject order");
          System.out.println("3) Add dvd");
          System.out.println("4) Remove dvd");
          System.out.println("5) Log out");
          System.out.println("Select action: ");
          m = sc.nextInt();
          sc.nextLine();
          switch (m) {
            case 1:
              admin.viewOrders();
              break;
            case 2:
              System.out.println("Enter a number from 0 to " + (unprocessedOrder.size() - 1) + " to response");
              m = sc.nextInt();
              admin.responseOrder(unprocessedOrder.get(m));
              unprocessedOrder.remove(m);
              break;
            case 3:
              admin.addItem();
              break;
            case 4:
              System.out.println("Enter a number from 0 to " + (store.itemsInStore.size() - 1) + " to remove");
              m = sc.nextInt();
              admin.removeItem(store.itemsInStore.get(m));
              break;
            case 5:
              admin.logout();
              b = true;
              break;
          }
          if (b)
            break;
        }
      }
      if (m == 0) {
        CustomerUser user = new CustomerUser();
        while (true) {
          System.out.println("1) View collection");
          System.out.println("2) Search for dvd");
          System.out.println("3) Play dvd demo");
          System.out.println("4) Display dvd details");
          System.out.println("5) Add to cart");
          System.out.println("6) Remove from cart");
          System.out.println("7) Sort cart");
          System.out.println("8) View hust.dsai.aims.cart.Cart");
          System.out.println("9) Search in cart");
          System.out.println("10) Place order");
          System.out.println("11) Pay for order");
          System.out.println("12) Exit session, all information will be discarded");

          m = sc.nextInt();
          sc.nextLine();
          switch (m) {
            case 1:
              for (Media item : store.itemsInStore) {
                item.printItem();
              }
              break;
            case 2:
              List<Media> l = searchInCollection();
              for (Media item : l) {
                item.printItem();
              }
              break;
            case 3:
              System.out.println("Select a number from 0 " + (store.itemsInStore.size() - 1) + " to play demo");
              m = sc.nextInt();
              if(store.itemsInStore.get(m) instanceof DigitalVideoDisc || store.itemsInStore.get(m) instanceof CompactDisc)
                ((Playable)store.itemsInStore.get(m)).play();
              else System.out.println("not a playable item");
              break;
            case 4:
              System.out.println("Select a number from 0 " + (store.itemsInStore.size() - 1) + " to display details");
              m = sc.nextInt();
              store.itemsInStore.get(m).printItem();
              break;
            case 5:
              System.out.println("Select a number from 0 " + (user.cart.itemsOrdered.size() - 1) + " to add to cart");
              m = sc.nextInt();
              user.cart.addMedia(store.itemsInStore.get(m));
              break;
            case 6:
              System.out
                  .println("Select a number from 0 " + (user.cart.itemsOrdered.size() - 1) + " to remove from cart");
              m = sc.nextInt();
              user.cart.removeMedia(user.cart.itemsOrdered.get(m));
              break;
            case 7:
              user.cart.sortByTitle();
              break;
            case 8:
              user.cart.printCart();
              break;
            case 9:
              break;
            case 10:
              user.placeOrder();
              break;
            case 11:
              user.payForOrder();
              break;
            case 12:
              b = true;
              break;
          }
          if (b)
            break;
        }
      }
    }
  }
}
