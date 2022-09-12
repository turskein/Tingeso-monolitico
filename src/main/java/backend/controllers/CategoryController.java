package backend.controllers;

import backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/asasd")
    public String main(Model model) {
        model.addAttribute("categorias",categoryService.obtenerCategorias());
        return "uploadDataView";
    }
}