package backend.TestsRepositories;

import backend.entities.TimestampEntity;
import backend.repositories.TimeStampRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestTimestampsReporitory {

    @Autowired
    TimeStampRepository timeStampRepository;

    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    void findById_staffAndDate(){
        System.out.println("======================");
        Date theDate;

        try{

            Long id = Integer.toUnsignedLong(1);

            theDate = simpleDateFormatForDate.parse("2022-08-01");
            List<TimestampEntity> timestampEntities = timeStampRepository.findById_staffAndDate(id,theDate);

            for (TimestampEntity timestamp: timestampEntities){
                System.out.println(timestamp);
            }

        }catch(ParseException e){
            System.out.println(e);
        }





        System.out.println("======================");
    }
}
