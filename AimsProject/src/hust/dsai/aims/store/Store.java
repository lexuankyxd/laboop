package hust.dsai.aims.store;

import hust.dsai.aims.disc.DigitalVideoDisc;

import java.util.ArrayList;

public class Store {

  public ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

  public void addToStore(DigitalVideoDisc disc) {
    itemsInStore.add(disc);
  }

  public void addToStore(DigitalVideoDisc[] discs) {
    for (DigitalVideoDisc disc : discs)
      itemsInStore.add(disc);
  }

  public void removeFromStore(DigitalVideoDisc disc) {
    itemsInStore.remove(disc);
  }

  public void removeFromStore(DigitalVideoDisc[] discs) {
    for(DigitalVideoDisc disc : discs) itemsInStore.remove(disc);
  }
}
