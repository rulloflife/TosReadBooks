package kh.edu.rupp.fe.ite.tosreadbooks.model;

public class Product {
    private int id;
    private String title;
    private String author;
    private int pages;
    private int views;
    private String thumbnailUrl;
    private String description;
    private double averageRating;
    private String type;
    private String release;

    public Product() {
    }

    public Product(int id, String title, String author, int pages, int views, String thumbnailUrl, String description, double averageRating, String type, String release) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.views = views;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.averageRating = averageRating;
        this.type = type;
        this.release = release;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public int getViews() {
        return views;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getType() {
        return type;
    }

    public String getRelease() {
        return release;
    }
}
