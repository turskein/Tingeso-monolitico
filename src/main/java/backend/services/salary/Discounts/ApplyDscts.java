package backend.services.salary.Discounts;

import backend.entities.StaffEntity;
import backend.entities.TimestampEntity;
import backend.repositories.JustificationRepository;
import backend.repositories.TimeStampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ApplyDscts {

    @Autowired
    DescByDelaySalary descByDelaySalary;

    @Autowired
    TimeStampRepository timeStampRepository;

    @Autowired
    MissingDay missingDay;

    @Autowired
    LimitsMonth limitsMonth;

    @Autowired
    JustificationRepository justificationRepository;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private double accumulatedDsctsToSalary(StaffEntity worker, int month, int year){
        Calendar start = Calendar.getInstance();
        start.setTime(limitsMonth.getStartDate(month,year));
        Calendar end = Calendar.getInstance();
        end.setTime(limitsMonth.getEndDate(month,year));
        double dsctos = 0;
        /*Iterations over day of month*/
        for (Date current = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), current = start.getTime()) {
            if(missingDay.isWorkableDay(current)){
                List<TimestampEntity> currentTimestamps = timeStampRepository.findById_staffAndDate(worker.getId_staff(),current);
                if(missingDay.isMissingDay(currentTimestamps)){
                    dsctos = dsctos + missingDay.noWorkedDay;
                }else{
                    TimestampEntity currentTimestamp = currentTimestamps.get(0);
                    if(descByDelaySalary.overSeventy(currentTimestamp)){
                        if(currentTimestamps.size() > 0){
                        }else {
                            dsctos = dsctos + missingDay.noWorkedDay;
                        }
                    }else {
                        dsctos = dsctos + descByDelaySalary.dsctoByDelay(currentTimestamp);
                    }

                }
            }
        }
        return dsctos;
    }

    public int applyDiscount(int salary, StaffEntity worker, int month, int year){
        return (int)(accumulatedDsctsToSalary(worker,month,year)*((double)salary));
    }

}
