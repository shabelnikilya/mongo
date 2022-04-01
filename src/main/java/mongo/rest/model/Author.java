package mongo.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "authors")
public class Author {
    @NotBlank(message = "Id must be not empty")
    @Id
    private String id;
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotBlank(message = "Surname must be not empty")
    private String surname;
    @NotNull(message = "Age must be non null")
    private int age;
    private List<Book> books;

    public Author() {
    }

    public Author(String id, String name, String surname, int age, List<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.books = books;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
