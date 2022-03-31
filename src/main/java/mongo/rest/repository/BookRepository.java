package mongo.rest.repository;

import mongo.rest.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'name': ?0}")
    Book findByName(String name);
}
