package com.cybage.dao;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
            Statement statement = connection.createStatement();) {
            String query = "select * from Product";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt(1));
                product.setProductName(resultSet.getString(5));
                product.setProductDescription(resultSet.getString(4));
                product.setProductCategory(Category.valueOf(resultSet.getString(2)));
                product.setProductCreatedDate(resultSet.getDate(3).toLocalDate());
                product.setProductPrice(resultSet.getDouble(6));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void save(Product product) {
        try(Connection connection = ConnectionUtil.getConnection()){
            String query="";
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
