package hust.dsai.aims.cart;

import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.media.Media;

import java.util.*;

/**
 * hust.dsai.aims.cart.Cart
 */
public class Cart {
  public double total;
  Scanner sc = new Scanner(System.in);

  public final List<Media> itemsOrdered = new ArrayList<>();

  public void addMedia(Media item) {
    itemsOrdered.add(item);
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
    ArrayList<Media> list = new ArrayList<>();
    for (Media item : itemsOrdered) {
      if (item.getTitle().equals(t))
        list.add(item);
    }
    return list;
  }

  public Media searchById(int i) {
    for (Media item : itemsOrdered) {
      if (item.getId() == i)
        return item;
    }
    return null;
  }
}
