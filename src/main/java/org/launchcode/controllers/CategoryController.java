package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.CheeseType;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        Iterable<Category> categories = categoryDao.findAll();

        model.addAttribute(categories);
        model.addAttribute("title", "Categories");

        return "category/index";
    }
///////////////////////////////CONTROLLER HANDLERS to Render and Process the Form////////////////////////////////////
    /////////////////////////////GET////////GET///////////GET///////////////////////////////////////////////////////
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {

        model.addAttribute(new Category());
        model.addAttribute("title", "Add Category");
        return "add";
    }

    ////////////////////////POST/////////////POST///////////////////////POST////////////////////////////////////////
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model,
                      @ModelAttribute @Valid Category category, Errors errors) {

        if (errors.hasErrors()) {

            return "add";
        }

        categoryDao.save(category);
        return "redirect:";
    }

}

