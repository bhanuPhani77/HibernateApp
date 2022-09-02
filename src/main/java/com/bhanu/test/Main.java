package com.bhanu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.bhanu.dao.BookDao;
import com.bhanu.dao.BookDaoImpl;
import com.bhanu.entity.Author;
import com.bhanu.entity.Book;

public class Main {

	public static void main(String[] args) {

		List<Author> list = List.of(new Author(103, "Chris"), new Author(104, "Hemsworth"));
		Book book = new Book();
		book.setBookId(2);
		book.setBookName("MARVEL");
		book.setAuthors(list);

		BookDao dao = new BookDaoImpl();
		if (dao.saveBook(book)) {
			System.out.println("New Order is Created");
		} else {
			System.out.println("Order Already Exist");
		}

		// 2.fetch All Customers
		List<Book> bookLst = dao.bookList();

		System.out.println(
				"============================================================================================================");
		bookLst.forEach(System.out::println);

		// 3.delete customer By Id
		// CustomerDao custDao = new CustomerDaoImpl();
		// custDao.deleteCustomer(101);

		// 4.Updated Customer By Id
		// custDao.updateCustomer(101);
	}

}
