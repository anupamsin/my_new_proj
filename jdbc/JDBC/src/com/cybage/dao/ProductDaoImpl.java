package com.cybage.dao;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        String query = "select * from Product";
        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();) {
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
    public boolean save(Product product) {
        String query = "insert into Product(product_id,product_name,product_description,product_category,product_created_date,product_price) values(?,?,?,?,?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setInt(1, product.getProductId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductDescription());
            preparedStatement.setString(4, product.getProductCategory().toString());
            preparedStatement.setDate(5, Date.valueOf(product.getProductCreatedDate()));
            preparedStatement.setDouble(6, product.getProductPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Optional<Product> findByProductId(int id) {
        Optional<Product> product = Optional.of(new Product());
        String query = "select *from Product where product_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product.get().setProductId(resultSet.getInt(1));
                product.get().setProductName(resultSet.getString(5));
                product.get().setProductDescription(resultSet.getString(4));
                product.get().setProductCategory(Category.valueOf(resultSet.getString(2)));
                product.get().setProductCreatedDate(resultSet.getDate(3).toLocalDate());
                product.get().setProductPrice(resultSet.getDouble(6));
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public String deleteById(int ids) {
        Optional<Product> product = findByProductId(ids);
        String query = "delete from Product where product_id=?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            if (findByProductId(ids).get().getProductId() == null) {
                return "No Product with Id : " + ids;
            }
            preparedStatement.setInt(1, ids);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Deleted Product : " + product.get();
    }

    @Override
    public String update(Product product) {
        Optional<Product> product1 = findByProductId(product.getProductId());
        String query = "update Product set product_name=?,product_price=?,product_description=?,product_category=? where product_id=?";
        try(Connection connection=ConnectionUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(query)){
            if(findByProductId(product.getProductId()).get().getProductId()==null){
                return "No such product exist";
            }
            preparedStatement.setString(1,product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setString(3, product.getProductDescription());
            preparedStatement.setString(4,product.getProductCategory().toString());
            preparedStatement.setInt(5,product.getProductId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return "Product Updated : "+product1.get();
    }
}
