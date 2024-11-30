package hust.dsai.aims.media;

public abstract class Media {
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
        return cost;
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
}
