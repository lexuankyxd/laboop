package hust.dsai.aims.media;

public class Disc extends  Media{
    private String director = "NULL";
    private int length = 0;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void printDisc() {
        System.out.println(
                "Id: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + ",  Director: " + getDirector()
                        + ", Length: " + getLength());
    }

    public void playDemo() {
        if (getLength() <= 0)
            System.out.println("Disc can not be played");
        else
            System.out.println("Disc demo played.");
    }
}
