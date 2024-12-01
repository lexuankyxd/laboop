package hust.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private final ArrayList<String> authors = new ArrayList<>();

    public Book(String title, String author, String category, double cost) {
        super();
        setId(getCnt());
        setTitle(title);
        this.authors.add(author);
        setCategory(category);
        setCost(cost);
    }

    Book(String title, ArrayList<String> authors, String category, double cost) {
        super();
        setId(getCnt());
        setTitle(title);
        this.authors.addAll(authors);
        setCategory(category);
        setCost(cost);
    }

    public void addAuthors(ArrayList<String> authors) {
        this.authors.addAll(authors);
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }

    public void removeAuthors(ArrayList<String> authors) {
        this.authors.removeAll(authors);
    }

    public void removeAuthor(String author) {
        this.authors.remove(author);
    }

    @Override
    public String toString() {
        String list_of_authors = String.join(", ", authors);
        return "Book{" +
                "authors=" + authors +
                '}';
    }
}
