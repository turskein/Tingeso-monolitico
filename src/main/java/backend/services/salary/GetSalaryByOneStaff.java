package backend.services.salary;

import backend.entities.CategoryEntity;
import backend.entities.StaffEntity;
import backend.repositories.CategoryRepository;
import backend.services.salary.discounts.ApplyDscts;
import backend.services.salary.discounts.Cotizations;
import backend.services.salary.extraSalary.Bonifications;
import backend.services.salary.extraSalary.ExtraHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSalaryByOneStaff {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SalaryByCategory salaryByCategory;

    @Autowired
    ApplyDscts applyDscts;

    @Autowired
    Bonifications bonifications;

    @Autowired
    ExtraHours extraHours;

    @Autowired
    Cotizations cotizations;

    private CategoryEntity getCategory(StaffEntity worker){
        long idCategory = worker.getIdCategory();
        return categoryRepository.findAllById(idCategory).get(0);
    }

    private int positiveSalary(int salary){
        if(salary > 0){
            return salary;
        }
        return 0;
    }

    public int getRawSalary(StaffEntity worker, int month, int year){
        CategoryEntity category = getCategory(worker);
        int salaryForWorker = salaryByCategory.getSalaryByCategory(category);
        int discounts = applyDscts.applyDiscount(salaryForWorker,worker,month,year);
        int salaryBonifications = bonifications.getBonifications(salaryForWorker,worker);
        int salaryForExtraHours = extraHours.salaryExtraHours(worker,category,month,year);

        return salaryForWorker+salaryBonifications+salaryForExtraHours-discounts;
    }
    public int getRealSalary(StaffEntity worker, int month, int year){
        int rawSalary = getRawSalary(worker, month, year);
        int cotizationsDiscounts = cotizations.getPrevisionalSalary(rawSalary);
        cotizationsDiscounts = cotizationsDiscounts + cotizations.getPrevisionalSalud(rawSalary);
        return positiveSalary(rawSalary - cotizationsDiscounts - cotizationsDiscounts);
    }

}
