package backend.TestServices;

import backend.repositories.TimeStampRepository;
import backend.services.UploadDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestUploadDataService {

    @Autowired
    TimeStampRepository timeStampRepository;
    @Autowired
    UploadDataService uploadDataService;

    @Test
    void uploadData(){
        String allInfo = new String();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "src/test/resources/timestamps.txt"))){
            String line = reader.readLine();
            while (line != null) {
                allInfo = allInfo + line + "\n";
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
        }

        assertEquals(0,uploadDataService.uploadTimeStamps(allInfo),0.0);
        timeStampRepository.deleteAll();
    }
}
