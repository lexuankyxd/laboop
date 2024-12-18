package hust.dsai.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    private int id;
    private String title;
    private String category;
    private double cost;
    private static int cnt = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return (double) Math.round(cost* 100) / 100;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCnt(){
        return cnt++;
    }

    public void printItem(){
        System.out.println("Title: " + getTitle() + "\nCategory: " + getCategory() + "\nCost: " + getCost() + "\nId: " + this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Media m){
          return m.getTitle().equals(title);
        }
        return false;
    }

    @Override
    public int compareTo(Media o) {
        return title.compareTo(o.getTitle());
    }

    public abstract String toString();
}
