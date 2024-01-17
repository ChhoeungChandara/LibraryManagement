package com.chandara.libraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandara.libraryManagement.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	List<Book> findBookByTitle(String title);

}
