package backend.TestServices;

import backend.entities.ExtraHoursEntity;
import backend.repositories.ExtraHoursRepository;
import backend.services.UploadExtraHoursService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TestExtraHoursService {

    @Autowired
    UploadExtraHoursService uploadExtraHoursService;

    @Autowired
    ExtraHoursRepository extraHoursRepository;
    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy/MM/dd");

    @Test
    void uploadExtrahour(){
        extraHoursRepository.deleteAll();

        ExtraHoursEntity newExtraHours = new ExtraHoursEntity();
        try{
            Date theDate = simpleDateFormatForDate.parse("2022/09/18");
            newExtraHours.setDate(theDate);
            newExtraHours.setAmount(2);
            uploadExtraHoursService.uploadExtraHours("23.537.297-5", newExtraHours);
            uploadExtraHoursService.uploadExtraHours("asdasdasd", newExtraHours);
        }catch (ParseException e){
        }

    }
}
