package mongo.rest.service;

import mongo.rest.model.Book;
import mongo.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService implements mongo.rest.service.Service<Book> {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Book save(Book book) {
       return repository.save(book);
    }

    @Override
    public void update(Book book) {
        if (this.findByName(book.getName()) != null) {
            repository.save(book);
        }
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
