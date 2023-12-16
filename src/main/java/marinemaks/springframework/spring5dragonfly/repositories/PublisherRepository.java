package marinemaks.springframework.spring5dragonfly.repositories;

import marinemaks.springframework.spring5dragonfly.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
