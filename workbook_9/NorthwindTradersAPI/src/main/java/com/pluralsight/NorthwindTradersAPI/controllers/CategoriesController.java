package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {
    @GetMapping("/categories")
    public List<Category> getAllCategories(@RequestParam(value = "name", required = false) String name) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Category A"));
        categories.add(new Category(2, "Category B"));

        return categories.stream()
                .filter(c -> (name == null || c.getCategoryName().equalsIgnoreCase(name)))
                .collect(Collectors.toList());
    }
}