package com.chandara.libraryManagement.Service.Impl;

import org.springframework.stereotype.Service;

import com.chandara.libraryManagement.Entity.Book;
import com.chandara.libraryManagement.Entity.User;
import com.chandara.libraryManagement.Exception.ResourceNotFoundException;
import com.chandara.libraryManagement.Repository.BookRepository;
import com.chandara.libraryManagement.Repository.UserRepository;
import com.chandara.libraryManagement.Service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final UserRepository userRepository;
	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookId(Long id) {
		return bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book", id));
	}

	@Override
	public void deleteBook(Long id) {
		Book bookId = getBookId(id);
		bookRepository.delete(bookId);
		
		
	}

	@Override
	public Book borrowBook(Long id, Long userId) {
		Book bookId = getBookId(userId);
		User user = userRepository.findById(userId)
				                  .orElseThrow(()-> new ResourceNotFoundException("user", userId));
		
		if(bookId!=null && !bookId.isBorrowed() && user!=null) {
			bookId.setBorrowedBy(user);
			bookId.setBorrowed(true);
			
			return addBook(bookId);
		}
		return null;
	}

	@Override
	public Book returnBook(Long id) {
		
		Book bookId = getBookId(id);
		if(bookId!=null && bookId.isBorrowed()) {
			bookId.setBorrowedBy(null);
			bookId.setBorrowed(false);
			return addBook(bookId);
		}
		return null;
	}


}
