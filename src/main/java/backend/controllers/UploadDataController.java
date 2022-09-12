package backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import backend.services.UploadDataService;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping
public class UploadDataController {
    @Autowired
    UploadDataService uploadDataService;

    @GetMapping("/upload-data")
    public String uploadView() {
        return "uploadDataView";
    }

    @PostMapping("/uploadtimestamps")
    @ResponseBody
    public ModelAndView uploadTimestamps(@RequestParam("file") MultipartFile file){
        int response = uploadDataService.uploadTimestamps(file);
        if(response == 0){
            return new ModelAndView("redirect:");
        }
        return new ModelAndView("redirect:/uploaddata");
    }
}
