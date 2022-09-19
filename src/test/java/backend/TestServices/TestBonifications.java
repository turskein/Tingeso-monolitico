package backend.TestServices;

import backend.FillDatabase;
import backend.entities.StaffEntity;
import backend.repositories.StaffRepository;
import backend.services.salary.extraSalary.Bonifications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestBonifications {
    @Autowired
    Bonifications bonifications;

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    FillDatabase fillDatabase;

    @Test
    void testYearsOfService() {
        StaffEntity worker1 = staffRepository.findByRut("23.537.297-5").get(0);
        assertEquals(22, bonifications.serviceYears(worker1), 0.0);

        StaffEntity worker2 = staffRepository.findByRut("20.847.783-8").get(0);
        assertEquals(5, bonifications.serviceYears(worker2), 0.0);

        StaffEntity worker3 = staffRepository.findByRut("18.292.684-1").get(0);
        assertEquals(2, bonifications.serviceYears(worker3), 0.0);
    }

    @Test
    void testBonifications(){
        StaffEntity worker1 = staffRepository.findByRut("23.537.297-5").get(0);
        assertEquals(14000, bonifications.getBonifications(100000,worker1), 0.0);

        StaffEntity worker2 = staffRepository.findByRut("20.847.783-8").get(0);
        assertEquals(5000, bonifications.getBonifications(100000,worker2), 0.0);

        StaffEntity worker3 = staffRepository.findByRut("18.292.684-1").get(0);
        assertEquals(0, bonifications.getBonifications(100000,worker3), 0.0);
    }

    @Test
    void bonificationsPercentage(){
        StaffEntity worker1 = staffRepository.findByRut("23.537.297-5").get(0);
        assertEquals(0.14, bonifications.bonificationsPercentage(worker1), 0.0);

        StaffEntity worker2 = staffRepository.findByRut("20.847.783-8").get(0);
        assertEquals(0.05, bonifications.bonificationsPercentage(worker2), 0.0);

        StaffEntity worker3 = staffRepository.findByRut("18.292.684-1").get(0);
        assertEquals(0, bonifications.bonificationsPercentage(worker3), 0.0);
    }

}
