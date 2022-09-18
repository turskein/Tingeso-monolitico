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
    @Test
    void contextLoads() {
        System.out.println(1);
    }

    @Test
    void getDate() {
        Date theDate;
        String str;
        Format f = new SimpleDateFormat("EEE");
        for (int i = 0; i < 7; i ++){
            str = "2022/09/"+Integer.toString(12+i);

            try{
                theDate = simpleDateFormatForDate.parse(str);
                System.out.println(f.format(theDate));
            }catch(ParseException e){
                System.out.println(e);
            }

        }
    }

    @Test
    void testsWithTime(){
        Time myTime = new Time(10,20,30);
        System.out.println(myTime.after(new Time(10,40,30)));
    }

    @Test
    void asdasd(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Calendar start = Calendar.getInstance();
            start.setTime(formatter.parse("2022-11-01"));
            Calendar end = Calendar.getInstance();
            end.setTime(formatter.parse("2022-12-01"));

            for (Date current = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), current = start.getTime()) {
                System.out.println(current.toString());
            }
        }catch (ParseException e){
            System.out.println(e);
        }
    }

    @Test
    void asdasdd(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat jaja = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        try{
            Date peo = formatter.parse("2022-10-10");
            System.out.println(jaja.format(peo));
        }catch (ParseException e) {
            System.out.println(e);
        }
    }

    SimpleDateFormat asdasd = new SimpleDateFormat("HH:mm");
    @Test
    void xdddd(){
        Time myTime = new Time(12,8,00);
        Time newTime = new Time(myTime.getTime()+3600000);
        System.out.println(myTime);
        System.out.println(newTime);
    }
}
