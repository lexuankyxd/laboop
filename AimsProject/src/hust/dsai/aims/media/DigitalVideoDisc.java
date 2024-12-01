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

  DigitalVideoDisc(String t, String c, String d, double co) {
    super();
    setId(getCnt());
    setTitle(t);
    setCost(co);
    setDirector(d);
    setCategory(c);
  }

  public DigitalVideoDisc(String t, String c, String d, int length, double co) {
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

  @Override
  public String toString() {
    return "DigitalDisc{" +
            "id=" + getId() +
            ", title='" + getTitle() + '\'' +
            ", category='" + getCategory() + '\'' +
            ", cost=" + getCost()  +
            "director='" + getDirector() + '\'' +
            ", length=" + getLength() +
            '}';
  }

  @Override
  public int compareTo(Media o){
    if(!(o instanceof DigitalVideoDisc)) return -1;
    if(getTitle().compareTo(o.getTitle()) != 0) return getTitle().compareTo(o.getTitle());
    if(getLength() != ((DigitalVideoDisc) o).getLength()) return getLength() - ((DigitalVideoDisc) o).getLength();
    return (int) (getCost() - o.getCost());
  }
}
