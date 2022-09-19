package backend.services.salary.extraSalary;

import backend.entities.StaffEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class Bonifications {
    double [] percentages = {0.05, 0.08, 0.11, 0.14, 0.17};
    int    [] extraYears   = {5, 10, 15, 20, 25};

    Calendar start = Calendar.getInstance();

    private Date addOneYear (){
        start.add(Calendar.DATE, 365);
        return start.getTime();

    }

    private Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public int serviceYears(StaffEntity worker){
        Date ingress = worker.getIngress();
        start.setTime(ingress);

        Date addedOneyear = addOneYear();

        Date currentDate = getCurrentDate();
        int yearOfService = 0;
        while(currentDate.after(addedOneyear) && yearOfService < 200){
            yearOfService ++;
            addedOneyear = addOneYear();
        }
        return yearOfService;

    }


    int    sizeExtras = 5;
    public double bonificationsPercentage(StaffEntity worker){
        int yearsOfService = serviceYears(worker);

        for (int i = sizeExtras-1; i >= 0; i--) {
            if(yearsOfService >= extraYears[i]){
                return percentages[i];
            }
        }
        return 0;
    }

    public int getBonifications(int salary, StaffEntity worker){
        return (int)(((double)salary)*bonificationsPercentage(worker));
    }

}
