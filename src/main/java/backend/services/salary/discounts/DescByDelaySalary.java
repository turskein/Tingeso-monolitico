package backend.services.salary.discounts;

import backend.entities.TimestampEntity;
import backend.repositories.JustificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class DescByDelaySalary {

    @Autowired
    JustificationRepository justificationRepository;

    Time tenMinuteDelay = new Time(8,10,0);
    Time twentyFiveMinuteDelay = new Time(8,25,0);
    Time fourtyFiveMinuteDelay = new Time(8,45,0);
    Time seventyMinuteDelay = new Time(9,10,0);

    double dsctoTen = 0.01;
    double dsctoTwentyFive = 0.03;
    double dsctoFourtyFive = 0.06;

    public boolean overSeventy(TimestampEntity timestamp){
        return seventyMinuteDelay.after(timestamp.getTime());
    }

    public double dsctoByDelay(TimestampEntity timestamp){
        if(fourtyFiveMinuteDelay.after(timestamp.getTime())){
            return dsctoFourtyFive;
        }else if(twentyFiveMinuteDelay.after(timestamp.getTime())){
            return dsctoTwentyFive;
        }else if (tenMinuteDelay.after(timestamp.getTime())) {
            return dsctoTen;
        }
        return 0;
    }
}
