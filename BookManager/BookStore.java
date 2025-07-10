package com.aurionpro.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookStore {
	private List<Book> books = new ArrayList<Book>();

	public void addbook(Book book) {
		books.add(book);
	}

	public void issuebook(int id) {
		for (Book book : books) {
			if (book.getId() == id && !book.isIssued()) {
				book.setIssued(true);
				System.out.println("Book issued succcesfully.");
				return;
			}
		}
		System.out.println("Book not found");
	}

	public void returnbook(int id) {
		for (Book book : books) {
			if (book.getId() == id && book.isIssued()) {
				book.setIssued(false);
				System.out.println("Book returned succcesfully.");
				return;
			}
		}
		System.out.println("Book not found");
	}

	public void displayAvailableBooks() {
		for (Book book : books) {
			if (!book.isIssued())
				System.out.println(book);
		}
	}

	public void displayIssuedBooks() {
		for (Book book : books) {
			if (book.isIssued())
				System.out.println(book);
		}
	}

	public void sortByAuthor() {
		Collections.sort(books, new BookAuthorComparator());
		System.out.println("Sorted by Author (Ascending):");
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public void sortByTitleDescending() {
		Collections.sort(books, new BookTitleComparator());
		System.out.println("Sorted by Title (Descending):");
		for (Book book : books) {
			System.out.println(book);
		}
	}

}
