package hust.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

  public DigitalVideoDisc() {
  super();
  }

  public DigitalVideoDisc(String t) {
    super();
    setTitle(t);
    setId(getCnt());
  }

  public DigitalVideoDisc(String t, String c, double co) {
    super();
    setId(getCnt());
    setTitle(t);
    setCost(co);
  }

  DigitalVideoDisc(String t, String c, String d, float co) {
    super();
    setId(getCnt());
    setTitle(t);
    setCost(co);
    setDirector(d);
    setCategory(c);
  }

  public DigitalVideoDisc(String t, String c, String d, int length, float co) {
    super();
    setId(getCnt());
    setTitle(t);
    setCost(co);
    setLength(length);
    setDirector(d);
    setCategory(c);
  }

  public void play(){
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
  }
}
