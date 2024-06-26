package com.pluralsight.NorthwindTradersAPI.dao;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCategoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Category> getAll() {
        String sql = "SELECT * FROM categories";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    @Override
    public Category getById(int id) {
        String sql = "SELECT * FROM categories WHERE CategoryID = ?";
        return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

    @Override
    public Category insert(Category category) {
        String sql = "INSERT INTO categories (CategoryName) VALUES (?)";
        jdbcTemplate.update(sql, category.getCategoryName());
        return category;
    }

    @Override
    public void update(int id, Category category) {
        String sql = "UPDATE categories SET CategoryName = ? WHERE CategoryID = ?";
        jdbcTemplate.update(sql, category.getCategoryName(), id);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM categories WHERE CategoryID = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Category(
                rs.getInt("CategoryID"),
                rs.getString("CategoryName")
            );
        }
    }
}