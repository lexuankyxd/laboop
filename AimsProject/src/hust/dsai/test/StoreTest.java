import hust.dsai.aims.disc.DigitalVideoDisc;
import hust.dsai.aims.store.Store;

public class StoreTest {
  public static void main(String[] args) {
    Store store = new Store();
    // Create new dvd objects and add them to the cart
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    store.addToStore(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
    store.addToStore(dvd2);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
    store.addToStore(dvd3);
    for (DigitalVideoDisc disc : store.itemsInStore)
      disc.printDisc();
    store.removeFromStore(dvd2);
    for (DigitalVideoDisc disc : store.itemsInStore)
      disc.printDisc();
  }
}
