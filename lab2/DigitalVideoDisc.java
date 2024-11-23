/**
 * DigitalVideoDisc
 */
public class DigitalVideoDisc {
  private String title;
  private String category;
  private String director;
  private int length = 0;
  private float cost = 0;

  DigitalVideoDisc(){}

  DigitalVideoDisc(String t) {
    this.title = t;
  }

  DigitalVideoDisc(String t, String c, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
  }

  DigitalVideoDisc(String t, String c, String d, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
    this.director = d;
  }

  DigitalVideoDisc(String t, String c, String d, int length, float co) {
    this.title = t;
    this.category = c;
    this.cost = co;
    this.director = d;
    this.length = length;
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

  void printDisc(){
    System.out.println("Title: " + title + ", Category: " + category + ", Cost: " + cost + ",  Director: " + director + ", Length: " + length);
  }

  void playDemo(){
    if(length <= 0) System.out.println("Disc can not be played");
    else System.out.println("Disc demo played.");
  }
}
