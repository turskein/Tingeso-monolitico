package backend.TestsRepositories;

import backend.entities.ExtraHoursEntity;
import backend.repositories.ExtraHoursRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestsExtrahoursRepository {

    @Autowired
    ExtraHoursRepository extraHoursRepository;

    @Test
    void findAllById_staffAndMonthAndYear(){
        Long id = Integer.toUnsignedLong(1);
        List<ExtraHoursEntity> extraHoursEntities = extraHoursRepository.findAllByIdStaffAndMonthAndYear(id,9,2022);
        System.out.println("======================");
        for (ExtraHoursEntity oneExtraHour: extraHoursEntities){
            System.out.println(oneExtraHour);
        }
        System.out.println("======================");
    }
}
