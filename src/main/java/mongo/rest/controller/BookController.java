package mongo.rest.controller;

import mongo.rest.model.Book;
import mongo.rest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return new ResponseEntity<>(service.save(book), HttpStatus.CREATED);
    }

    @GetMapping("/find-id/{id}")
    public Book getBookById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/find-name/{name}")
    public Book getBookByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/find-all")
    public List<Book> findAll() {
        return (List<Book>) service.findAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody Book book) {
        service.update(book);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
