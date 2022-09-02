package com.bhanu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.bhanu.entity.Author;
import com.bhanu.entity.Book;


public class BookDaoImpl implements BookDao {

	static SessionFactory sessionFactory;

	static {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		sessionFactory = metadata.buildSessionFactory();
	}
	public boolean saveBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();

		try {
			session.save(book);
			txn.commit();
			return true;
		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	public List<Book> bookList() {
		Session session = sessionFactory.openSession();
		Criteria cri = session.createCriteria(Book.class);
		List<Book> books = cri.list();

		return books;
	}

	@Override
	public void deleteBook(Integer bookId) {
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
		
		Book book1 = session.get(Book.class, bookId);
		if (book1 != null) {
			session.delete(book1);
			System.out.println("Book is deleted");
			txn.commit();
			}else {
				System.out.println("Book Not Exist ");
			}

		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


	/*
	@Override
	public void updateCustomer(Integer custId) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		try {
		
		Customer customer2 = session.get(Customer.class, custId);
		if (customer2 != null) {
			List<Orders> lstOrders = Arrays.asList(
					new Orders(105, "Credit_Card_Payment", 18500.0), 
					new Orders(107, "COD", 2800.0)
					);
			customer2.setCustomerName("Koti");
			customer2.setOrders(lstOrders);
			
			//session.save(customer2);
			System.out.println("Customer updated by Id "+custId);
			txn.commit();
			}else {
				System.out.println("Customer Not Exist with Id is "+custId);
			}

		} catch (Exception e) {
			txn.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	*/
}
