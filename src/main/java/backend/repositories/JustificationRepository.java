package backend.repositories;

import backend.entities.JustificationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface JustificationRepository extends CrudRepository<JustificationEntity, Long>{

    @Query(
            value = "SELECT * FROM justification WHERE id_staff = ?1 AND date =?2",
            nativeQuery = true
    )
    public List<JustificationEntity> findById_staffAndDate(Long Id, Date date);
}