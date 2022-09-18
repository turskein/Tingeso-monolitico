package backend.services.salary.Discounts;

import org.springframework.stereotype.Service;

@Service
public class Cotizations {
    double previsional = 0.1;
    double salud = 0.08;

    public int getPrevisionalSalary(int salaryRaw){
        return (int)(previsional* (double) salaryRaw);
    }
    public int getPrevisionalSalud(int salaryRaw){
        return (int)(salud * (double) salaryRaw);
    }
}
