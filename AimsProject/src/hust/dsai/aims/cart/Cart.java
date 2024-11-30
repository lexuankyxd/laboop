package hust.dsai.aims.cart;

import hust.dsai.aims.media.DigitalVideoDisc;

import java.util.*;

/**
 * hust.dsai.aims.cart.Cart
 */
public class Cart {
  public float total;
  Scanner sc = new Scanner(System.in);

  public final List<DigitalVideoDisc> itemsOrdered = new ArrayList<>();

  public void addDigitalVideoDisc(DigitalVideoDisc item) {
    itemsOrdered.add(item);
    itemsOrdered.get(0).printDisc();
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void addDigitalVideoDisc(DigitalVideoDisc item1, DigitalVideoDisc item2) {
    itemsOrdered.add(item1);
    itemsOrdered.get(0).printDisc();
    itemsOrdered.add(item2);
    itemsOrdered.get(0).printDisc();
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void addDigitalVideoDisc(DigitalVideoDisc[] items) {
    for (DigitalVideoDisc item : items) {
      itemsOrdered.add(item);
      itemsOrdered.get(0).printDisc();
    }
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void removeDigitalVideoDisc(DigitalVideoDisc item) {
    itemsOrdered.remove(item);
    System.out.println("Removed item from cart.");
  }

  public void totalCost() {
    total = 0;
    for (DigitalVideoDisc item : this.itemsOrdered)
      total += item.getCost();
  }

  public void printCart() {
    System.out.println("The cart content: " + itemsOrdered.size());
    for (DigitalVideoDisc item : itemsOrdered)
      item.printDisc();
  }

  public void sortCart() {
    int m;
    System.out.println("Enter input mode(1 for by title, 2 for category, 3 for cost): ");
    m = sc.nextInt();
    switch (m) {
      case 1:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override
          public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            return d1.getTitle().compareTo(d2.getTitle());
          }
        });
        break;

      case 2:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override
          public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            return d1.getCategory().compareTo(d2.getCategory());
          }
        });
        break;
      default:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override
          public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            if (d1.getCost() < d2.getCost())
              return -1;
            return d1.getCost() > d2.getCost() ? 1 : 0;
          }
        });
    }
  }

  private boolean checkIfListContains(ArrayList<String> arr, String s) {
    for (String str : arr)
      if (s.contains(str))
        return true;
    return false;
  }

  public List<DigitalVideoDisc> searchByTitle(String t) {
    ArrayList<DigitalVideoDisc> list = new ArrayList<>();
    for (DigitalVideoDisc item : itemsOrdered) {
      if (item.getTitle().equals(t))
        list.add(item);
    }
    return list;
  }

  public DigitalVideoDisc searchById(int i) {
    for (DigitalVideoDisc item : itemsOrdered) {
      if (item.getId() == i)
        return item;
    }
    return null;
  }
}
