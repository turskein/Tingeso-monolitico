package backend.repositories;

import backend.entities.StaffEntity;
import lombok.Generated;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Generated
public interface StaffRepository extends CrudRepository<StaffEntity, Long>{

    public List<StaffEntity> findByRut(String rut);
}
