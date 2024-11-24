package hust.dsai.aims.disc;

/**
 * hust.dsai.aims.disc.DigitalVideoDisc
 */

public class DigitalVideoDisc {
  private String title = "NULL";
  private String category = "NULL";
  private String director = "NULL";
  private int length = 0;
  private float cost = 0;
  private int id;
  private static int nbDigitalDVDDiscs = 0;

  public DigitalVideoDisc() {
  }

  public DigitalVideoDisc(String t) {
    this.title = t;
    this.id = nbDigitalDVDDiscs;
    nbDigitalDVDDiscs++;
  }

  public DigitalVideoDisc(String t, String c, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
    this.id = nbDigitalDVDDiscs;
    nbDigitalDVDDiscs++;
  }

  DigitalVideoDisc(String t, String c, String d, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
    this.director = d;
    this.id = nbDigitalDVDDiscs;
    nbDigitalDVDDiscs++;
  }

  public DigitalVideoDisc(String t, String c, String d, int length, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
    this.director = d;
    this.length = length;
    this.id = nbDigitalDVDDiscs;
    nbDigitalDVDDiscs++;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public int getLength() {
    return length;
  }

  public String getDirector() {
    return director;
  }

  public float getCost() {
    return this.cost;
  }

  public String getCategory() {
    return category;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void printDisc() {
    System.out.println(
        "Id: " + id + ", Title: " + title + ", Category: " + category + ", Cost: " + cost + ",  Director: " + director
            + ", Length: " + length);
  }

  public void playDemo() {
    if (length <= 0)
      System.out.println("Disc can not be played");
    else
      System.out.println("Disc demo played.");
  }
}
