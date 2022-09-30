package backend.repositories;

import backend.entities.ExtraHoursEntity;
import lombok.Generated;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Generated
public interface ExtraHoursRepository extends CrudRepository<ExtraHoursEntity, Long>{

    @Query(
            value = "SELECT * FROM extra_hours WHERE id_staff = ?1 AND EXTRACT(MONTH FROM date) = ?2 AND EXTRACT(YEAR FROM date) = ?3",
            nativeQuery = true
    )
    List<ExtraHoursEntity> findAllByIdStaffAndMonthAndYear(Long idStaff, int month, int year);
}
