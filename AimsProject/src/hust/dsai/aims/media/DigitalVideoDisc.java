package hust.dsai.aims.media;

/**
 * hust.dsai.aims.media.DigitalVideoDisc
 */

public class DigitalVideoDisc extends Disc {



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
}