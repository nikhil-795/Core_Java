package org.example.solid.SRP;

//model
public class Product {
    private int id;
    private String name;
    private String description;
    private int price;

    public Product(String description, int price, int id, String name) {
        this.description = description;
        this.price = price;
        this.id = id;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
