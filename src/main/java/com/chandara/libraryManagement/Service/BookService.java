package com.chandara.libraryManagement.Service;

import com.chandara.libraryManagement.Entity.Book;

public interface BookService {
	Book addBook(Book book);
	Book getBookId(Long id);
	void deleteBook(Long id);
	Book borrowBook(Long id,Long userId);
	Book returnBook(Long id);
}
