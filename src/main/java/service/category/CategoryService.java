package service.category;

import config.ConnectionSingleton;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory {
    Connection connection = ConnectionSingleton.getConnection();

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void save(Category category) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into category(name) value (?);");
            preparedStatement.setString(1, category.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object findByID(int id) {
        return null;
    }


    @Override
    public void remove(int id) {

    }

    @Override
    public List<Category> checkCategory(int id) {
        List<Category> categories = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("call checkCategory(?);");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Category category = new Category(name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
