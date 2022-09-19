package backend;

import backend.repositories.TimeStampRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import backend.services.salary.GetSalaryByOneStaff;

import java.sql.Time;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class Proy1ApplicationTests {

    @Autowired
    GetSalaryByOneStaff getRawSalaryByStaff;

    @Autowired
    TimeStampRepository timeStampRepository;

    SimpleDateFormat simpleDateFormatForDate = new SimpleDateFormat("yyyy/MM/dd");
}
