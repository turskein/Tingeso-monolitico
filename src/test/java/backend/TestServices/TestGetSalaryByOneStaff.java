package backend.TestServices;

import backend.entities.StaffEntity;
import backend.repositories.StaffRepository;
import backend.services.salary.GetSalaryByOneStaff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGetSalaryByOneStaff {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    GetSalaryByOneStaff getSalaryByOneStaff;

    @Test
    void testGetRealSalary(){
        StaffEntity worker = staffRepository.findByRut("23.537.297-5").get(0);
        System.out.println(getSalaryByOneStaff.getRealSalary(worker,8,2022));
    }



}
