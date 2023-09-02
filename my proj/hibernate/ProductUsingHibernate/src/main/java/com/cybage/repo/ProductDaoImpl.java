package com.cybage.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cybage.model.Product;
import com.cybage.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Product> getAllEmployee() {
		Transaction transaction=null;
		List<Product> products=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction=session.beginTransaction();
		// get products by creating query
			products=session.createQuery("from Product").list();
		// commit transcation
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
		}
		return products;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String createProduct(Product product) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction=session.beginTransaction();
		// get products by creating query
			session.save(product);
		// commit transcation
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
		}
		return "Product Created Successfully";
	}

	@Override
	public Product getProductById(Integer productId) {
		Transaction transaction=null;
		Product product=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			product=session.get(Product.class, productId);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return product;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String productDeleteByIds(Product product) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.delete(product);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return "Deleted Sucessfully \n"+product.toString();
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public String updateProductById(Product product) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction=session.beginTransaction();
		// get products by creating query
			session.saveOrUpdate(product);
		// commit transcation
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
                transaction.rollback();
            }
		}
		return "Product Updated Successfully";

	}

}
