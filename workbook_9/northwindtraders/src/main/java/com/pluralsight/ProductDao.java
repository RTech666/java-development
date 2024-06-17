package com.pluralsight;
import java.util.List;

public interface ProductDao {
    // Initalize methods.
    void add(Product product);
    List<Product> getAll();
    void deleteByName(String name);
    void updateByName(String name, Product updatedProduct);
    Product searchByName(String name);
}
