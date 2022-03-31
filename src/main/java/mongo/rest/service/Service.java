package mongo.rest.service;

public interface Service<T> {

    Iterable<T> findAll();

    T findByName(String name);

    T save(T t);

    void update(T t);

    void deleteById(String id);

    T findById(String id);
}
