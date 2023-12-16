package marinemaks.springframework.spring5dragonfly.repositories;

import marinemaks.springframework.spring5dragonfly.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
