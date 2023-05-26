package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllCategory(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "category/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("category",new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("category")Category category){
        categoryService.addCategory(category);
        return "redirect:/books";
    }
}
