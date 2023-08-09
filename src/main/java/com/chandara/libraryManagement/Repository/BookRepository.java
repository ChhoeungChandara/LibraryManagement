package com.chandara.libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandara.libraryManagement.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
