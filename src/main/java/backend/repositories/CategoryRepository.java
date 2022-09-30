package backend.repositories;

import backend.entities.CategoryEntity;
import lombok.Generated;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Generated
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>{

    public List<CategoryEntity> findAllById(Long id);
    public List<CategoryEntity> findByCategory(String category);
}
