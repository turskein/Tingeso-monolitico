package backend.services.salary.ExtraSalary;

import backend.entities.CategoryEntity;
import backend.entities.StaffEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Service
public class Bonifications {
    double [] percentages = {0.05, 0.08, 0.11, 0.14, 0.17};
    int    [] extraYears   = {5,10,15,20,25};

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private Date newDate (Date oldDate, int years){
        int oldYear = oldDate.getYear();
        int oldMonth = oldDate.getMonth();
        int oldDay = oldDate.getDay();

        try {
            Date newDate = formatter.parse((oldYear+years)+"-"+oldMonth+"-"+oldDay);
            return newDate;
        }catch (ParseException e){
            System.out.println(e);
        }
        return null;
    }

    private Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    int    sizeExtras = 5;
    public double bonifications(StaffEntity worker){
        Date ingress = worker.getIngress();

        Date currentDate = getCurrentDate();
        for (int i = sizeExtras-1; i >= 0; i--) {
            if(currentDate.before(newDate(ingress,extraYears[i]))){
                return percentages[i];
            }
        }
        return 0;
    }

    public int getBonifications(int salary, StaffEntity worker){
        return (int)(((double)salary)*bonifications(worker));
    }

}
