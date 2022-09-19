package backend.controllers;

import backend.entities.Salary;
import backend.services.GetSalaryForEveryStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    GetSalaryForEveryStaff getSalaryForEveryStaff;


    @GetMapping("/sheet-salary")
    public String viewSheetSalary() {
        return "sheetSalary";
    }

    @GetMapping("/reports")
    public String viewReportSalaries() {
        return "reportOfSalaries";
    }

    @GetMapping("/get-salary/{month}/{year}")
    @ResponseBody
    public List<Salary> getSalaryForEveryMonth(
            @PathVariable("month") int month,
            @PathVariable("year")  int year
    ){
        return getSalaryForEveryStaff.getSalaryForEveryStaff(month,year);
    }

}
