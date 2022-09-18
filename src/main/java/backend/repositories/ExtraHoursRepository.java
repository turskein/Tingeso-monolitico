package backend.repositories;

import backend.entities.ExtraHoursEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraHoursRepository extends CrudRepository<ExtraHoursEntity, Long>{

    @Query(
            value = "SELECT * FROM extra_hours WHERE id_staff = ?1 AND EXTRACT(MONTH FROM date) = ?2 AND EXTRACT(YEAR FROM date) = ?3",
            nativeQuery = true
    )
    List<ExtraHoursEntity> findAllById_staffAndMonthAndYear(Long id_staff, int month, int year);
}
