package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {
    private final ProductDao productDao;

    @Autowired
    public ProductsController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "unitPrice", required = false) Double unitPrice) {

        List<Product> products = productDao.getAll();

        if (name != null) {
            products = products.stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());
        }
        if (categoryId != null) {
            products = products.stream()
                    .filter(p -> p.getCategoryId() == categoryId)
                    .collect(Collectors.toList());
        }
        if (unitPrice != null) {
            products = products.stream()
                    .filter(p -> p.getUnitPrice() == unitPrice)
                    .collect(Collectors.toList());
        }

        return products;
    }
}