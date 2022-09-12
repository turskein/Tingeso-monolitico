package backend.controllers;

import backend.services.UploadExtraHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import backend.entities.ExtraHoursEntity;
import backend.entities.JustificationEntity;
import backend.services.UploadJustifiveService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UploadJustifiveController {

    @Autowired
    UploadJustifiveService uploadJustifiveService;

    @Autowired
    UploadExtraHoursService uploadExtraHoursService;

    @GetMapping("/upload-justifive")
    public String uploadView() {
        return "uploadJustifiveView";
    }

    @GetMapping("/problems-with-justifive")
    public String problems() {
        return "problemsWithJustifive";
    }


    @PostMapping("/0/{rut}")
    @ResponseBody
    public String uploadJustifyBackwardness(@PathVariable("rut") String rut,
                                         @RequestBody JustificationEntity justificationEntity){
        if(uploadJustifiveService.uploadJustifive(rut,justificationEntity) == 1){
            return "1";
        }
        return "0";
    }

    @PostMapping("/1/{rut}")
    @ResponseBody
    public String uploadJustifyExtraHours(@PathVariable("rut") String rut,
                                       @RequestBody ExtraHoursEntity extraHoursEntity){

        if(uploadExtraHoursService.uploadExtraHours(rut,extraHoursEntity) == 1){
            return "1";
        }
        return "0";
    }

}
