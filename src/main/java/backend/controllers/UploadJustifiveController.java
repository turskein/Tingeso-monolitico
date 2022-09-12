package backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class UploadJustifiveController {

    @GetMapping("/upload-justifive")
    public String uploadView() {
        return "uploadJustifiveView";
    }

    @PostMapping("/{rut}")
    public int uploadJusttifyBackwardness(@PathVariable("rut") String rut, @RequestBody int jaj){
        return 1;
    }

}
