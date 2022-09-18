package backend.repositories;

import backend.entities.TimestampEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimeStampRepository extends CrudRepository<TimestampEntity, Long>{

    @Query(
            value = "SELECT * FROM timestamp WHERE id_staff = ?1 AND date =?2 ORDER BY time ASC",
            nativeQuery = true
    )
    List<TimestampEntity> findByIdStaffAndDate(Long idStaff, Date date);

}
