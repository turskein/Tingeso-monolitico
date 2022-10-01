package backend.controllers;

import backend.entities.Salary;
import backend.services.GetSalaryForEveryStaff;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salary")
@Generated
public class SalaryController {

    @Autowired
    GetSalaryForEveryStaff getSalaryForEveryStaff;


    @GetMapping("/sheet-salary")
    public String viewSheetSalary(Model model) {
        List<Salary> everySalary = getSalaryForEveryStaff.getSalaryForEveryStaff(9,2022);
        model.addAttribute("salaries",everySalary);
        return "sheetSalary";
    }

    @GetMapping("/reports")
    public String viewReportSalaries(Model model) {
        List<Salary> everySalary = getSalaryForEveryStaff.getSalaryForEveryStaff(9,2022);
        model.addAttribute("salaries",everySalary);
        return "reportOfSalaries";
    }

}
