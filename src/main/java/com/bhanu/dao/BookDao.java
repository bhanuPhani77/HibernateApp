package com.bhanu.dao;

import java.util.List;

import com.bhanu.entity.Author;
import com.bhanu.entity.Book;

public interface BookDao {

	boolean saveBook(Book book);
	void deleteBook(Integer bookId);
//	void updateBook(Integer bookId);
	public List<Book> bookList();
	
}
