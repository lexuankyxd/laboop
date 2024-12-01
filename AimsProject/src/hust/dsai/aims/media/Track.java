package hust.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void play(){
        System.out.println("Playing track " + title);
        System.out.println("Track's length " + length);
    }

     @Override
     public boolean equals(Object obj){
        if(obj instanceof Track){
            return ((Track)obj).getTitle().equals(title) && ((Track)obj).getLength() == length;
        }
        return false;
     }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", length=" + length +
                '}';
    }
}
