package com.pluralsight.NorthwindTradersSpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Product product) {
        String sql = "INSERT INTO products (product_id, name, category, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getProductId(), product.getName(), product.getCategory(), product.getPrice());
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public void deleteByName(String name) {
        String sql = "DELETE FROM products WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    @Override
    public void updateByName(String name, Product updatedProduct) {
        String sql = "UPDATE products SET name = ?, category = ?, price = ? WHERE name = ?";
        jdbcTemplate.update(sql, updatedProduct.getName(), updatedProduct.getCategory(), updatedProduct.getPrice(), name);
    }

    @Override
    public Product searchByName(String name) {
        String sql = "SELECT * FROM products WHERE name = ?";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), name);
        return products.isEmpty() ? null : products.get(0);
    }
}