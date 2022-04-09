package mongo.rest.repository;

import mongo.rest.model.Authority;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuthoritiesRepository extends MongoRepository<Authority, String> {

//    @Query("{'username': ?0}")
    List<Authority> findByUsername(String username);
}
