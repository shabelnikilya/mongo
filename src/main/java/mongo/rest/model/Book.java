package mongo.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document(collection = "books")
public class Book {
    @NotBlank(message = "Id must be not empty")
    @Id
    private String id;
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotNull(message = "Number of pages be non null")
    private int numberPages;
    private double price;
    @NotNull(message = "Author must be not empty")
    private Author author;

    public Book() {
    }

    public Book(String id, String name, int numberPages, double price, Author author) {
        this.id = id;
        this.name = name;
        this.numberPages = numberPages;
        this.price = price;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
