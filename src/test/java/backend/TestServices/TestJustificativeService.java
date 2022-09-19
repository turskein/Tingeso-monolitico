package backend.TestServices;

import backend.FillDatabase;
import backend.entities.JustificationEntity;
import backend.services.UploadJustifiveService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class TestJustificativeService {

    @Autowired
    UploadJustifiveService uploadJustifiveService;

    @Autowired
    FillDatabase fillDatabase;
    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy/MM/dd");

    @Test
    void uploadJustificative(){
        JustificationEntity newJustification = new JustificationEntity();
        try{
            Date theDate = simpleDateFormatForDate.parse("2022/09/18");
            newJustification.setDate(theDate);
            uploadJustifiveService.uploadJustifive("23.537.297-5", newJustification);
        }catch (ParseException e){
        }
    }
}
