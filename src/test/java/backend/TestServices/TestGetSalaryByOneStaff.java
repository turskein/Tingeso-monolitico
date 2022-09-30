package backend.TestServices;

import backend.entities.StaffEntity;
import backend.repositories.StaffRepository;
import backend.repositories.TimeStampRepository;
import backend.services.UploadDataService;
import backend.services.salary.GetSalaryByOneStaff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
public class TestGetSalaryByOneStaff {

    @Autowired
    TimeStampRepository timeStampRepository;
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    UploadDataService uploadDataService;

    @Autowired
    GetSalaryByOneStaff getSalaryByOneStaff;

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

        uploadDataService.uploadTimeStamps(allInfo);
    }

    @Test
    void testGetRealSalary(){
        uploadData();
        StaffEntity workerOne = staffRepository.findByRut("23.537.297-5").get(0);
        StaffEntity workerTwo = staffRepository.findByRut("20.847.783-8").get(0);
        StaffEntity workerThree = staffRepository.findByRut("18.292.684-1").get(0);
        getSalaryByOneStaff.getRealSalary(workerOne,9,2022);
        getSalaryByOneStaff.getRealSalary(workerTwo,9,2022);
        getSalaryByOneStaff.getRealSalary(workerThree,9,2022);
    }
}
