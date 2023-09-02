package com.cybage.repo;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cybage.model.Category;
import com.cybage.model.Product;
import com.cybage.util.HibernateUtil;

@SuppressWarnings({"deprecation", "unchecked"})
public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getAllEmployee() {
        Transaction transaction = null;
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            products = session.createQuery("from Product").list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return products;
    }

    @Override
    public String createProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            session.persist(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return "Product Created Successfully";
    }

    @Override
    public Product getProductById(Integer productId) {
        Transaction transaction = null;
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            product = session.get(Product.class, productId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return product;
    }

    @Override
    public String productDeleteByIds(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return "Deleted Sucessfully \n" + product.toString();

    }

    @Override
    public String updateProductById(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            session.saveOrUpdate(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return "Product Updated Successfully";

    }

    @Override
    public List<Product> getFilterProdByDate(LocalDate fromDate, LocalDate toDate) {
        Transaction transaction = null;
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            products = session
                    .createQuery("from Product where productCreatedDate >=: fromDate and productCreatedDate <=:toDate")
                    .setParameter("fromDate", fromDate).setParameter("toDate", toDate).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return products;
    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        Transaction transaction = null;
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            products = session.createQuery("from Product where productCategory =:category")
                    .setParameter("category", category).list();
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return products;
    }

    /*@Override
    public Product getProductByProductName(String productName) {
        Transaction transaction = null;
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start transaction
            transaction = session.beginTransaction();
            // get products by creating query
            //product = session.createQuery("from Product where productName =:productName")
             //       .setParameter("productName", productName);
            product=session.get(Product.class,productName);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return product;
    }*/
}
