package com.bhanu.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="BOOK")

public class Book {
	
	@Id
	@Column(name = "BOOK_ID")
	private Integer bookId; 

	@Column(name = "BOOKNAME")
	private String bookName;
	
	@ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Book_Author", 
	    joinColumns = @JoinColumn(name="BOOK_ID_FK",referencedColumnName = "BOOK_ID"),
	    inverseJoinColumns = @JoinColumn(name="AUTHOR_ID_FK", referencedColumnName = "AUTHOR_ID"))
	private List<Author> authors;
	

}
