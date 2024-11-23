import java.util.*;

/**
 * Cart
 */
public class Cart {
  float total;
  Scanner sc = new Scanner(System.in);

  public final List<DigitalVideoDisc> itemsOrdered =  new ArrayList<>();

  public void addDigitalVideoDisc(DigitalVideoDisc item) {
    itemsOrdered.add(item);
    itemsOrdered.get(0).printDisc();
    System.out.println("The cart now has " + itemsOrdered.size() + " items.");
  }

  public void removeDigitalVideoDisc(DigitalVideoDisc item) {
    itemsOrdered.remove(item);
    System.out.println("Removed item from cart.");
  }

  public void  totalCost() {
    total = 0;
    for (DigitalVideoDisc item : this.itemsOrdered)
      total += item.getCost();
  }

  public void printCart() {
    System.out.println("The cart content: " + itemsOrdered.size());
    for (DigitalVideoDisc item : itemsOrdered)
      item.printDisc();
  }

  public void sortCart(){
    int m;
    System.out.println("Enter input mode(1 for by title, 2 for category, 3 for cost): ");
    m = sc.nextInt();
    switch (m){
      case 1:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            return d1.getTitle().compareTo(d2.getTitle());
          }
        });
        break;

      case 2:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            return d1.getCategory().compareTo(d2.getCategory());
          }
        });
        break;
      default:
        Collections.sort(itemsOrdered, new Comparator<DigitalVideoDisc>() {
          @Override public int compare(DigitalVideoDisc d1, DigitalVideoDisc d2) {
            if(d1.getCost() < d2.getCost()) return -1;
            return d1.getCost() > d2.getCost() ? 1 : 0;
          }
        });
    }
  }
  private boolean checkIfListContains(ArrayList<String> arr, String s){
    for(String str: arr) if(s.contains(str)) return true;
    return false;
  }
  public List<DigitalVideoDisc> searchInCart(){
    List<DigitalVideoDisc> res = new ArrayList<>();
    int m;
    System.out.println("Enter search mode(1 for title, 2 for category, 3 for cost range): ");
    m = sc.nextInt();
    int t = 0;
    float c1 = 0, c2 = 0;
    ArrayList<String> keywords = new ArrayList<>();
    if(m != 3) {
      System.out.println("Enter amount of keywords and a list of keywords seperated by space: ");
      t = sc.nextInt();
      for(int i = 0; i < t; i++) keywords.add(sc.next());
    }else {
      System.out.println("Enter range of price: ");
      c1 = sc.nextFloat();
      c2 = sc.nextFloat();
    }
    switch (m){
      case 1:
        for(DigitalVideoDisc item : itemsOrdered){
          if(checkIfListContains(keywords, item.getTitle())) {
            res.add(item);
          }
        }
        break;
      case 2:
        for(DigitalVideoDisc item : itemsOrdered){
          if(checkIfListContains(keywords, item.getCategory())) {
            res.add(item);
          }
        }
        break;
      default:
        for(DigitalVideoDisc item : itemsOrdered){
          if(c1 <= item.getCost() && item.getCost() <= c2) res.add(item);
        }
    }
    return res;
  }
}
