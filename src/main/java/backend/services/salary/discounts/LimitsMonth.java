package backend.services.salary.discounts;

import lombok.Generated;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Generated
@Service
public class LimitsMonth {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Date getStartDate(int month, int year){
        try{
            return formatter.parse(year+"-"+month+"-"+1);
        }catch(ParseException e){
            return null;
        }
    }

    public Date getEndDate(int month, int year){
        try{
            if(month == 12){
                return formatter.parse((year+1)+"-"+1+"-"+1);
            }
            return formatter.parse(year+"-"+(month+1)+"-"+1);
        }catch (ParseException e){
            return null;
        }
    }
}
