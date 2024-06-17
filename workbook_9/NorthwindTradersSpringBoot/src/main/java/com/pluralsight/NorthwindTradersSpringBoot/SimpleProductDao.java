package com.pluralsight.NorthwindTradersSpringBoot;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleProductDao implements ProductDao {
    // Create variable, as private.
    private List<Product> products;

    // Create the constructor.
    public SimpleProductDao() {
        this.products = new ArrayList<>();
        
        // Add test items.
        this.products.add(new Product(1, "Laptop", "Electronics", 1200.0));
        this.products.add(new Product(2, "Chair", "Furniture", 150.0));
    }

    // Create override methods.
    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void deleteByName(String name) {
        products.removeIf(product -> product.getName().equalsIgnoreCase(name));
    }

    @Override
    public void updateByName(String name, Product updatedProduct) {
        Optional<Product> existingProduct = products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();

        existingProduct.ifPresent(product -> {
            product.setName(updatedProduct.getName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
        });
    }

    @Override
    public Product searchByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}