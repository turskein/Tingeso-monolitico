package backend.controllers;

import lombok.Generated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@Generated
public class IndexController {

    @GetMapping("/index")
    public String main() {
        return "indexView";
    }
}
