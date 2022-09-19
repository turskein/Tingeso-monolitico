package backend.services;


import backend.entities.CategoryEntity;
import backend.entities.Salary;
import backend.entities.StaffEntity;
import backend.repositories.CategoryRepository;
import backend.repositories.StaffRepository;
import backend.services.salary.GetSalaryByOneStaff;
import backend.services.salary.discounts.ApplyDscts;
import backend.services.salary.discounts.Cotizations;
import backend.services.salary.extraSalary.Bonifications;
import backend.services.salary.extraSalary.ExtraHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetSalaryForEveryStaff {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    GetSalaryByOneStaff getSalaryByOneStaff;
    @Autowired
    Bonifications bonifications;

    @Autowired
    Cotizations cotizations;

    @Autowired
    ExtraHours extraHours;

    @Autowired
    ApplyDscts applyDscts;

    @Autowired
    StaffRepository staffRepository;

    public CategoryEntity getCategory(StaffEntity worker){
        long idCategory = worker.getIdCategory();
        return categoryRepository.findAllById(idCategory).get(0);
    }

    public List<Salary> getSalaryForEveryStaff(int monnth, int year){
        List<StaffEntity> staffEntities = (List<StaffEntity>)staffRepository.findAll();
        List<Salary> everySalary = new ArrayList<>();
        for (int i = 0; i < staffEntities.size(); i++){
            Salary currentSalary = new Salary();

            StaffEntity currentWorker = staffEntities.get(i);
            CategoryEntity currentCategory = getCategory(currentWorker);

            currentSalary.setName(currentWorker.getName());
            currentSalary.setLastName(currentWorker.getLastname());
            currentSalary.setRut(currentWorker.getRut());
            currentSalary.setCategory(currentSalary.getCategory());

            int serviceYears = bonifications.serviceYears(currentWorker);
            currentSalary.setServiceYears(serviceYears);
            int fixedSalary = getSalaryByOneStaff.getFixedSalary(currentCategory);

            currentSalary.setFixedSalary(fixedSalary);
            int bonificationSalary = bonifications
                    .getBonifications(
                            fixedSalary,
                            currentWorker
                    );
            currentSalary.setBonificationsSalary(bonificationSalary);
            int extraHoursSalary = extraHours
                    .salaryExtraHours(
                            currentWorker,
                            currentCategory,
                            monnth,
                            year
                    );
            currentSalary.setExtraHoursSalary(extraHoursSalary);
            int discountSalary = applyDscts
                    .applyDiscount(
                            fixedSalary,
                            currentWorker,
                            monnth,
                            year
                    );
            currentSalary.setDiscountsSalary(discountSalary);

            int rawSalary = getSalaryByOneStaff.getRawSalary(
                    currentWorker,
                    monnth,
                    year
            );
            currentSalary.setRawSalary(rawSalary);

            int previsionalSalary = cotizations.getPrevisionalSalary(rawSalary);
            currentSalary.setPrevisionalSalary(previsionalSalary);
            int healthSalary = cotizations.getPrevisionalSalud(rawSalary);
            currentSalary.setHealthSalary(healthSalary);
            int realSalary = getSalaryByOneStaff
                    .getRealSalary(
                            currentWorker,
                            monnth,
                            year
                    );
            currentSalary.setRealSsalary(realSalary);

            everySalary.add(currentSalary);
        }
        return everySalary;
    }
}
