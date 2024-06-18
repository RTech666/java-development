package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.dao.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoriesController {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories(@RequestParam(value = "name", required = false) String name) {
        List<Category> categories = categoryDao.getAll();

        if (name != null) {
            categories = categories.stream()
                    .filter(c -> c.getCategoryName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }

        return categories;
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }

    @PutMapping("/categories/{id}")
    public void updateCategory(@PathVariable int id, @RequestBody Category category) {
        categoryDao.update(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryDao.delete(id);
    }
}