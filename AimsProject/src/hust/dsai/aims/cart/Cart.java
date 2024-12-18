package hust.dsai.aims.cart;

import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

/**
 * hust.dsai.aims.cart.Cart
 */
public class Cart {
  public double total;
  Scanner sc = new Scanner(System.in);

  public final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
  public void addMedia(Media item) {
    itemsOrdered.add(item);
    System.out.println("The cart now has " + itemsOrdered.stream().filter(m -> m == item).count() + " of " + item.getTitle());
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void addMedia(Media item1, Media item2) {
    itemsOrdered.add(item1);
    itemsOrdered.add(item2);
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void addMedia(Media[] items) {
    itemsOrdered.addAll(Arrays.asList(items));
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void removeMedia(Media item) {
    itemsOrdered.remove(item);
    System.out.println("Removed item from cart.");
  }

  public double totalCost() {
    total = 0;
    for (Media item : this.itemsOrdered)
      total += item.getCost();
    total = (double) Math.round(total * 100) / 100;
    return total;
  }

  public void printCart() {
    System.out.println("The cart content: " + itemsOrdered.size());
    for (Media item : itemsOrdered) {
      item.printItem();
    }
  }

  public void sortByCategory(){
    itemsOrdered.sort(new Comparator<Media>() {
        @Override
        public int compare(Media d1, Media d2) {
            return d1.getCategory().compareTo(d2.getCategory());
        }
    });
  }

  public void sortByTitle(){
    itemsOrdered.sort(new Comparator<Media>() {
        @Override
        public int compare(Media d1, Media d2) {
            return d1.getTitle().compareTo(d2.getTitle());
        }
    });
  }

  public void sortByPrice(){
    itemsOrdered.sort(new Comparator<Media>() {
        @Override
        public int compare(Media d1, Media d2) {
            if (d1.getCost() < d2.getCost())
                return -1;
            return d1.getCost() > d2.getCost() ? 1 : 0;
        }
    });
  }



  private boolean checkIfListContains(ArrayList<String> arr, String s) {
    for (String str : arr)
      if (s.contains(str))
        return true;
    return false;
  }

  public List<Media> searchByTitle(String t) {
    return itemsOrdered.stream().filter(m -> m.getTitle().contains(t.toLowerCase())).toList();
  }

  public Media searchById(int i) {
    for (Media item : itemsOrdered) {
      if (item.getId() == i)
        return item;
    }
    return null;
  }
}
