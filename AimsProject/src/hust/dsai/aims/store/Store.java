package hust.dsai.aims.store;

import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;

public class Store {

  public ArrayList<Media> itemsInStore = new ArrayList<>();

  public void addToStore(Media item) {
    itemsInStore.add(item);
  }

  public void addToStore(Media[] items) {
      itemsInStore.addAll(Arrays.asList(items));
  }

  public void removeFromStore(Media item) {
    itemsInStore.remove(item);
  }

  public void removeFromStore(Media[] items) {
    itemsInStore.removeAll(Arrays.asList(items));
  }
}
