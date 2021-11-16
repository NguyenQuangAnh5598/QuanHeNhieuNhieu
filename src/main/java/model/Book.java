package model;

import java.util.List;

public class Book {
    private int id;
    private String name;
    private double price;
    private List<Category> categoryList;

    public Book(int id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book(String name, double price, List<Category> categoryList) {
        this.name = name;
        this.price = price;
        this.categoryList = categoryList;
    }

    public Book(int id, String name, double price, List<Category> categoryList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryList = categoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}