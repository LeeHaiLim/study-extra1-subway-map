package subway.domain;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T save(T t);
    List<T> findAll();
    void delete(T t);
    Optional<T> findByName(String name);
}
