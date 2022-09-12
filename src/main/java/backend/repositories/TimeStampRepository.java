package backend.repositories;

import backend.entities.TimestampEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeStampRepository extends CrudRepository<TimestampEntity, Long>{
}
