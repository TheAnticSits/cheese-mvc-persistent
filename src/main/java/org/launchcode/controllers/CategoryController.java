package org.launchcode.controllers;


import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        Iterable<Category> categories = categoryDao.findAll();
        model.addAttribute("title", "Categories");
        model.addAttribute("categories", categories);


        return "category/index";
    }
///////////////////////////////CONTROLLER HANDLERS to Render and Process the Form////////////////////////////////////
    /////////////////////////////GET////////GET///////////GET///////////////////////////////////////////////////////

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {


        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category());

        return "category/add";
    }

    ////////////////////////POST/////////////POST///////////////////////POST////////////////////////////////////////
    //ModelAttribute binds the object to this handler///////Valid makes sure that validation is satisfied///////////
    //Errors errors should come after the model that it is associated with//
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Category category, Errors errors) {

        /////////////check for errors if there are errors return to add/////////////////////////

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Category");
            return "category/add";
        }
        ////////////////if no errors save the new item and return to the index///////////////////////////////////

        categoryDao.save(category);
        return "redirect:";
    }

}

