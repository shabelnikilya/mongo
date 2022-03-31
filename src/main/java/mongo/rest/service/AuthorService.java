package mongo.rest.service;

import mongo.rest.model.Author;
import mongo.rest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AuthorService implements Service<Author> {
    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Author findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public void update(Author author) {
        if (this.findByName(author.getName()) != null) {
            repository.save(author);
        }
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
