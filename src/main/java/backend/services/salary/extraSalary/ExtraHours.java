package backend.services.salary.extraSalary;


import backend.entities.CategoryEntity;
import backend.entities.ExtraHoursEntity;
import backend.entities.StaffEntity;
import backend.entities.TimestampEntity;
import backend.repositories.ExtraHoursRepository;
import backend.repositories.TimeStampRepository;
import backend.services.CategoryService;
import backend.services.salary.SalaryByCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class ExtraHours {
    @Autowired
    ExtraHoursRepository extraHoursRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    TimeStampRepository timeStampRepository;

    @Autowired
    SalaryByCategory salaryByCategory;

    private List<ExtraHoursEntity> getExtraHoursByStaffAndDate(StaffEntity worker, int month, int year){
        return extraHoursRepository.findAllByIdStaffAndMonthAndYear(worker.getIdStaff(),month,year);
    }

    private TimestampEntity getTimeStampByWorkerAndDate(StaffEntity worker, Date date){
        try{
            return timeStampRepository.findByIdStaffAndDate(worker.getIdStaff(),date).get(1);
        }catch (Exception e){
            return null;
        }

    }

    public Time getTimeFromTimestamp(TimestampEntity timestamp){
        try{
            return timestamp.getTime();
        }catch (Exception e){
            return null;
        }
    }

    private Time lessOneHour(Time time){
        long oneHour = 3600000;
        return new Time(time.getTime()-oneHour);
    }

    private boolean thereAreTimeStamp(TimestampEntity timestamp){
        return timestamp == null;
    }

    Time departureTime = new Time(16,0,0);

    private int validateExtraHours(StaffEntity worker,ExtraHoursEntity extraHour){
        Date dateOfExtraHour = extraHour.getDate();

        TimestampEntity timeStampOfDayExtraHours = getTimeStampByWorkerAndDate(worker, dateOfExtraHour);
        if(thereAreTimeStamp(timeStampOfDayExtraHours)){
            return 0;
        }

        Time timeOfTimeStamp = getTimeFromTimestamp(timeStampOfDayExtraHours);

        Time lessedTime = lessOneHour(timeOfTimeStamp);

        int validateExtraHours = 0;

        while(validateExtraHours < extraHour.getAmount() && lessedTime.after(departureTime)){
            lessedTime = lessOneHour(lessedTime);
            validateExtraHours ++;
        }

        return validateExtraHours;
    }

    public int salaryExtraHours(StaffEntity worker, CategoryEntity category, int month, int year){
        int amountOneExtraHours = salaryByCategory.getSalExtraHoursByCat(category);

        int validatedAmountExtraHour = 0;
        List<ExtraHoursEntity> everyExtraHour = getExtraHoursByStaffAndDate(worker, month, year);
        for(int i = 0; i < everyExtraHour.size(); i ++){
            validatedAmountExtraHour = validatedAmountExtraHour + validateExtraHours(worker,everyExtraHour.get(i));
        }

        return validatedAmountExtraHour*amountOneExtraHours;
    }

}
