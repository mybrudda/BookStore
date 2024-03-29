package hh.sof03.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {


     @Autowired
    private CategoryRepository repository;
    
    @GetMapping("/categorylist")
    public String categoryList(Model model){
        model.addAttribute("categories",repository.findAll());
 
        return "categorylist";
 
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model){
    model.addAttribute("category", new Category());
    return "addCategory";
}

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute("category") Category category){
    repository.save(category);
    return "redirect:/categorylist";
}
}


