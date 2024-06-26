package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT * FROM products WHERE ProductID = ?";
        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
    }

    @Override
    public Product insert(Product product) {
        String sql = "INSERT INTO products (ProductName, CategoryID, UnitPrice) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getProductName(), product.getCategoryId(), product.getUnitPrice());
        return product;
    }

    @Override
    public void update(int id, Product product) {
        String sql = "UPDATE products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE ProductID = ?";
        jdbcTemplate.update(sql, product.getProductName(), product.getCategoryId(), product.getUnitPrice(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM products WHERE ProductID = ?";
        jdbcTemplate.update(sql, id);
    }


    private static final class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Product(
                rs.getInt("ProductID"),
                rs.getString("ProductName"),
                rs.getInt("CategoryID"),
                rs.getDouble("UnitPrice")
            );
        }
    }
}