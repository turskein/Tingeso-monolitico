package backend.repositories;

import backend.entities.ExtraHoursEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraHoursRepositoty extends CrudRepository<ExtraHoursEntity, Long>{
}
