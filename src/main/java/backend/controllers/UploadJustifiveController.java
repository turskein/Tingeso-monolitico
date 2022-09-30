package backend.controllers;

import backend.services.UploadExtraHoursService;

import java.sql.Date;
import java.util.Map;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import backend.entities.ExtraHoursEntity;
import backend.entities.JustificationEntity;
import backend.services.UploadJustifiveService;

@Controller
@RequestMapping("/upload-justifive")
@Generated
public class UploadJustifiveController {

    @Autowired
    UploadJustifiveService uploadJustifiveService;

    @Autowired
    UploadExtraHoursService uploadExtraHoursService;

    @GetMapping
    public String uploadView() {
        return "uploadJustifiveView-copy";
    }

    @GetMapping("/problems-with-justifive")
    public String problems() {
        return "problemsWithJustifive";
    }


    @PostMapping("/0")
    public String uploadJustifyBackwardness(@RequestParam(value="rut") String rut,
                                         @RequestParam(value="date") Date date,
                                         Model model){
    uploadJustifiveService.uploadJustifive(rut,date);
        
        return "redirect:/upload-justifive";
    }

    @PostMapping("/1")
    public String uploadJustifyExtraHours(@RequestParam(value="rut") String rut,
                                        @RequestParam(value="date") Date date,
                                        @RequestParam(value = "amount") int amount,
                                        Model model){

    uploadExtraHoursService.uploadExtraHours(rut,date,amount);

        return "redirect:/upload-justifive";
    }
}