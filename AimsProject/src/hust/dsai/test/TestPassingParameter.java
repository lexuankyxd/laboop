package hust.dsai.test;

import hust.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

  public static void main(String[] args) {

    // TODO Auto-generated method stub
    DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
    DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

    swap(jungleDVD, cinderellaDVD);
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    changeTitle(jungleDVD, cinderellaDVD.getTitle());
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());
  }

  public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
    String title = o1.getTitle(), category = o1.getCategory(), director = o1.getDirector();
    int length = o1.getLength();
    double cost = o1.getCost();
    o1.setTitle(o2.getTitle());
    o1.setCategory(o2.getCategory());
    o1.setDirector(o2.getDirector());
    o1.setLength(o2.getLength());
    o1.setCost(o2.getCost());
    o2.setTitle(title);
    o2.setCategory(category);
    o2.setDirector(director);
    o2.setLength(length);
    o2.setCost(cost);
  }

  public static void changeTitle(DigitalVideoDisc dvd, String title) {
    String oldTitle = dvd.getTitle();
    dvd.setTitle(title);
    dvd = new DigitalVideoDisc(oldTitle);
  }
}
