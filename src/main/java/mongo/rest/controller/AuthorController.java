package mongo.rest.controller;

import mongo.rest.model.Author;
import mongo.rest.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Author> save(@Valid @RequestBody Author author) {
        return new ResponseEntity<>(service.save(author), HttpStatus.CREATED);
    }

    @GetMapping("/find-id/{id}")
    public Author getAuthorById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/find-name/{name}")
    public Author getAuthorByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/find-all")
    public List<Author> findAll() {
        return (List<Author>) service.findAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@Valid @RequestBody Author author) {
        service.update(author);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
