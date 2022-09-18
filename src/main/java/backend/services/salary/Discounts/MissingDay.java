package backend.services.salary.Discounts;


import backend.entities.JustificationEntity;
import backend.entities.StaffEntity;
import backend.repositories.JustificationRepository;
import backend.entities.JustificationEntity;
import backend.entities.TimestampEntity;
import backend.repositories.TimeStampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class MissingDay {

    @Autowired
    JustificationRepository justificationRepository;

    @Autowired
    TimeStampRepository timeStampRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);

    String[] WorksDay = {"Monday", "Tuesday" ,"Thursday", "Wednesday", "Friday", "Saturday", "Sunday"};

    double noWorkedDay = 0.15;

    public boolean isWorkableDay(Date date){
        String weekDay = formatter.format(date);

        for (String workDay: WorksDay) {
            if(weekDay.equals(workDay)){
                return true;
            }
        }
        return false;
    }

    public boolean isMissingDay(List<TimestampEntity> days){
        return !(days.size() > 0);
    }

}
