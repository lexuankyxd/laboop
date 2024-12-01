package hust.dsai.test;

import hust.dsai.aims.media.Book;
import hust.dsai.aims.media.CompactDisc;
import hust.dsai.aims.media.DigitalVideoDisc;
import hust.dsai.aims.media.Media;

import java.util.ArrayList;

public class PolimorphismTest {
    public static void main(String[] args) {
        ArrayList<Media> media = new ArrayList<>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("Godzilla", "Action", "idk", 12, 11.99);
        Book book = new Book("twightlight", "idk", "romance", 9.99);
        CompactDisc cd = new CompactDisc("Graduation", "kanye", "hiphop", 20, "kanye", 60);
        media.add(dvd);
        media.add(book);
        media.add(cd);
        for(Media m : media) {
            System.out.println(m.toString());
        }
    }
}
