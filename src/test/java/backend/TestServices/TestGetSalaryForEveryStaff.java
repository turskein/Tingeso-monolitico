package backend.TestServices;

import backend.entities.Salary;
import backend.services.GetSalaryForEveryStaff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestGetSalaryForEveryStaff {
    @Autowired
    GetSalaryForEveryStaff getSalaryForEveryStaff;

    @Test
    public void testGetSalaryForEveryStaff(){
        List<Salary> gotSalaries = getSalaryForEveryStaff.getSalaryForEveryStaff(1,2022);
    }

}
