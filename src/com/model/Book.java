package com.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "inc-gen")
	private int bookId;
	private String isbn;
	private String bookName;
	
	@ManyToMany
	private Collection<UserDetails> authors = new ArrayList<UserDetails>();

	public Book() {

	}

	public Book(int bookid, String isbn, String bookName, Collection<UserDetails> authors) {
		this.bookId = bookid;
		this.isbn = isbn;
		this.bookName = bookName;
		this.authors = authors;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Collection<UserDetails> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<UserDetails> authors) {
		this.authors = authors;
	}

}
