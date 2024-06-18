package com.pluralsight.NorthwindTradersAPI.controllers;
import com.pluralsight.NorthwindTradersAPI.dao.ProductDao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {
        productDao.update(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productDao.delete(id);
    }
}