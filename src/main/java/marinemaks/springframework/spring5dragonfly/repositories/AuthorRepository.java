package marinemaks.springframework.spring5dragonfly.repositories;

import marinemaks.springframework.spring5dragonfly.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
