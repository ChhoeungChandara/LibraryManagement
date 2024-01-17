package com.chandara.libraryManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandara.libraryManagement.Entity.Book;
import com.chandara.libraryManagement.Service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Book book){
		return ResponseEntity.ok(bookService.addBook(book));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return ResponseEntity.ok(bookService.getBookId(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("{id}/borrow/{userId}")
	public ResponseEntity<?> borrowBook(@PathVariable Long id,@PathVariable Long userId){
		
		Book borrowBook = bookService.borrowBook(id, userId);
		if(borrowBook!=null) {
			return ResponseEntity.ok(borrowBook);
		}
		else {
		return ResponseEntity.badRequest().build();
	   }
	}
	
	@PostMapping("{bookId}/return")
	public ResponseEntity<?> returnBook(@PathVariable Long bookId){
		Book returnBook = bookService.returnBook(bookId);
		
		if(returnBook!=null) {
			return ResponseEntity.ok(returnBook);
		}
		else {
		return ResponseEntity.badRequest().build();
	    }
	}
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(bookService.getAll());
	}
	@GetMapping("filter")
	public ResponseEntity<?> finbookByTitle(@RequestParam("title") String title){
		return ResponseEntity.ok(bookService.findBookByTitle(title));
	}
}
