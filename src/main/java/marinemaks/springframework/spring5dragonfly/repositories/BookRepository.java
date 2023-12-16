package marinemaks.springframework.spring5dragonfly.repositories;

import marinemaks.springframework.spring5dragonfly.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
