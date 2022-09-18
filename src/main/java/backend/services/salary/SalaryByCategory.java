package backend.services.salary;

import backend.entities.CategoryEntity;
import backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryByCategory {

    @Autowired
    CategoryService categoryService;

    String catA = "A";
    String catB = "B";
    String catC = "C";

    int salaryForA = 1700000;
    int salaryForB = 1200000;
    int salaryForC = 800000;

    int extraHourSalCatA = 25000;
    int extraHourSalCatB = 20000;
    int extraHourSalCatC = 10000;

    int getSalaryByCategory(CategoryEntity category){
        if(categoryService.isCategoryA(category)){
            return salaryForA;
        }
        if(categoryService.isCategoryB(category)){
            return salaryForB;
        }
        if(categoryService.isCategoryC(category)) {
            return salaryForC;
        }
        return 0;
    }

    public int getSalExtraHoursByCat(CategoryEntity category){
        if(categoryService.isCategoryA(category)){
            return extraHourSalCatA;
        }
        if(categoryService.isCategoryB(category)){
            return extraHourSalCatB;
        }
        if(categoryService.isCategoryC(category)) {
            return extraHourSalCatC;
        }
        return 0;
    }
}
