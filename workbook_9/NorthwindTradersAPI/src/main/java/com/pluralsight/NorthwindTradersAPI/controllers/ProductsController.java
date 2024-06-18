package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {
    @GetMapping("/products")
    public List<Product> getAllProducts(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "unitPrice", required = false) Double unitPrice) {
        
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product A", 1, 10.0));
        products.add(new Product(2, "Product B", 1, 20.0));
        products.add(new Product(3, "Product C", 2, 30.0));

        return products.stream()
                .filter(p -> (name == null || p.getProductName().equalsIgnoreCase(name)))
                .filter(p -> (categoryId == null || p.getCategoryId() == categoryId))
                .filter(p -> (unitPrice == null || p.getUnitPrice() == unitPrice))
                .collect(Collectors.toList());
    }
}