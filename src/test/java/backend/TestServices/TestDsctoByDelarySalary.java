package backend.TestServices;

import backend.entities.StaffEntity;
import backend.entities.TimestampEntity;
import backend.repositories.StaffRepository;
import backend.repositories.TimeStampRepository;
import backend.services.salary.discounts.DescByDelaySalary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TestDsctoByDelarySalary {
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    TimeStampRepository timeStampRepository;
    @Autowired
    DescByDelaySalary descByDelaySalary;

    @Test
    public void testDelay(){
        TimestampEntity timestamp1 = ((List<TimestampEntity>)timeStampRepository.findAll()).get(0);
        timestamp1.setTime(new Time(8,46,0));
        assertEquals(0.06,descByDelaySalary.dsctoByDelay(timestamp1),0);
        timestamp1.setTime(new Time(8,27,0));
        assertEquals(0.03,descByDelaySalary.dsctoByDelay(timestamp1),0);
        timestamp1.setTime(new Time(8,11,0));
        assertEquals(0.01,descByDelaySalary.dsctoByDelay(timestamp1),0);
        timestamp1.setTime(new Time(8,0,0));
        assertEquals(0,descByDelaySalary.dsctoByDelay(timestamp1),0);
        timestamp1.setTime(new Time(9,10,0));
        assertFalse(descByDelaySalary.overSeventy(timestamp1));
        timestamp1.setTime(new Time(9,11,0));
        assertFalse(!descByDelaySalary.overSeventy(timestamp1));
    }
}
