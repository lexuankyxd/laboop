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

}
