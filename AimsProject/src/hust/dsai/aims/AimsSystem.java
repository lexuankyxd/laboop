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

  public static CustomerUser currentCustomer = new CustomerUser();

  public static void showMenu() {
    while (true) {
      System.out.println("AIMS: ");
      System.out.println("--------------------------------");
      System.out.println("1. View store");
      System.out.println("2. Update store");
      System.out.println("3. See current cart");
      System.out.println("0. Exit");
      System.out.println("--------------------------------");
      System.out.println("Please choose a number: 0-1-2-3");
      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          storeMenu();
          break;
        case 2:
          updateStoreMenu();
          break;
        case 3:
          cartMenu();
          break;
      }
    }
  }

  public static void updateStoreMenu() {
    Optional<Media> tmp;
    Media m;
    while (true) {
      System.out.println("Update store menu");
      System.out.println("--------------------------------");
      System.out.println("1. List items in store");
      System.out.println("2. Add item");
      System.out.println("3. Remove item");
      System.out.println("0. Exit");
      System.out.println("--------------------------------");
      System.out.println("Please choose a number: 0-1-2-3");
      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          for (Media item : store.itemsInStore) item.printItem();
          break;
        case 2:
          addItemToStore();
          break;
        case 3:
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          store.itemsInStore.remove(m);
          break;
      }
    }
  }

  private static void addItemToStore() {
    System.out.println("Choose media's type 1 - dvd, 2 - cd, 3 - book");
    int mediaType = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the media's title: ");
    String title = sc.nextLine();
    System.out.println("Enter the media's category: ");
    String category = sc.nextLine();
    System.out.println("Enter the media's cost: ");
    double cost = sc.nextDouble();
    sc.nextLine();
    if (mediaType == 1 || mediaType == 2) {
      System.out.println("Enter media's length (int): ");
      int length = sc.nextInt();
      sc.nextLine();
      System.out.println("Enter media's director: ");
      String director = sc.nextLine();
      if (mediaType == 1)
        store.itemsInStore.add(new DigitalVideoDisc(title, category, director, length, cost));
      else {
        System.out.println("Enter media's artist: ");
        String artist = sc.nextLine();
        System.out.println("Enter media's track length: ");
        int trackListSize = sc.nextInt();
        sc.nextLine();
        ArrayList<Track> trackList = new ArrayList<>();
        while (trackListSize != trackList.size()) {
          System.out.println("Enter track number " + trackList.size() + " title: ");
          String trackTitle = sc.nextLine();
          System.out.println("Enter track number " + trackList.size() + " length: ");
          int trackLength = sc.nextInt();
          sc.nextLine();
          trackList.add(new Track(title, length));
          System.out.println("----");
        }
        CompactDisc tmpDisc = new CompactDisc(title, artist, category, cost, director, length);
        tmpDisc.addTracks(trackList);
        store.itemsInStore.add(tmpDisc);
      }
    } else if (mediaType == 3) {
      System.out.println("Enter media's number of author: ");
      int numberOfAuthor = sc.nextInt();
      sc.nextLine();
      if (numberOfAuthor == 1) {
        System.out.println("Enter author name: ");
        store.itemsInStore.add(new Book(title, sc.nextLine(), category, cost));
        return;
      }
      ArrayList<String> authorList = new ArrayList<>();
      while (numberOfAuthor != authorList.size()) {
        System.out.println("Enter author number " + authorList.size() + " name: ");
        authorList.add(sc.nextLine());
      }
      Book tmp = new Book(title, authorList, category, cost);
      store.itemsInStore.add(tmp);
    } else {
      System.out.println("Invalid choice!");
    }
  }

  public static void storeMenu() {
    Optional<Media> tmp;
    Media m;
    while (true) {
      for (Media item : store.itemsInStore) {
        item.printItem();
      }
      System.out.println("Options: ");
      System.out.println("--------------------------------");
      System.out.println("1. See a media’s details");
      System.out.println("2. Add a media to cart");
      System.out.println("3. Play a media");
      System.out.println("4. See current cart");
      System.out.println("0. Back");
      System.out.println("--------------------------------");
      System.out.println("Please choose a number: 0-1-2-3-4");
      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          sc.nextLine();
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          mediaDetailsMenu(m);
          break;
        case 2:
          sc.nextLine();
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          currentCustomer.cart.addMedia(m);
          break;
        case 3:
          sc.nextLine();
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          if (m instanceof Playable) ((Playable) m).play();
          else System.out.println("Selected item is not playable!");
          break;
        case 4:
          break;
      }
    }
  }

  public static void mediaDetailsMenu(Media m) {
    boolean b = m instanceof Playable;
    System.out.println(m.toString());
    while (true) {
      System.out.println("Options: ");
      System.out.println("--------------------------------");
      System.out.println("1. Add to cart");
      if (b)
        System.out.println("2. Play");
      System.out.println("0. Back");
      System.out.println("--------------------------------");
      System.out.println("Please choose a number: 0-1-2");
      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          currentCustomer.cart.addMedia(m);
          break;
        case 2:
          if (b) ((Playable) m).play();
      }
    }
  }

  public static void cartMenu() {
    Optional<Media> tmp;
    Media m;
    while (true) {
      System.out.println("Options: ");
      System.out.println("--------------------------------");
      System.out.println("1. Filter medias in cart");
      System.out.println("2. Sort medias in cart");
      System.out.println("3. Remove media from cart");
      System.out.println("4. Play a media");
      System.out.println("5. Place order");
      System.out.println("0. Back");
      System.out.println("--------------------------------");
      System.out.println("Please choose a number: 0-1-2-3-4-5");
      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          System.out.println("Choose filter mode 1 - id, 2 - title: ");
          int mode = sc.nextInt();
          if (mode == 1) {
            System.out.println("Enter id: ");
            Media tm = currentCustomer.cart.searchById(sc.nextInt());
            if (tm != null) {
              tm.printItem();
            } else System.out.println("Not found!");
          } else if (mode == 2) {
            sc.nextLine();
            List<Media> tm = currentCustomer.cart.searchByTitle(sc.nextLine());
            for (Media med : tm)
              med.printItem();
          } else {
            System.out.println("Invalid option!");
          }
          break;
        case 2:
          System.out.println("Choose sorting mode 1 - title, 2 - category, 3 Price");
          int sortMode = sc.nextInt();
          if (sortMode == 1) currentCustomer.cart.sortByTitle();
          else if (sortMode == 2) currentCustomer.cart.sortByCategory();
          else if (sortMode == 3) currentCustomer.cart.sortByPrice();
          else System.out.println("Invalid option!");
          break;
        case 3:
          sc.nextLine();
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          currentCustomer.cart.removeMedia(m);
          break;
        case 4:
          sc.nextLine();
          System.out.println("Enter media name: ");
          tmp = store.itemsInStore.stream().filter(media -> media.getTitle().toLowerCase().compareTo(sc.nextLine().toLowerCase()) == 0).findFirst();
          if (tmp.isEmpty()) {
            System.out.println("Not found!");
          }
          m = tmp.get();
          if (m instanceof Playable) ((Playable) m).play();
          else System.out.println("Selected item is not playable!");
          break;
        case 5:
          System.out.println("order placed!");
          break;

      }
    }
  }

  public static void main(String[] args) {
    showMenu();
  }
}
