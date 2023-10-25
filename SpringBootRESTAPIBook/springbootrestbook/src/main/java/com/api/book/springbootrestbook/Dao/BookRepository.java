package com.api.book.springbootrestbook.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.springbootrestbook.entities.Book;



public interface BookRepository extends CrudRepository<Book,Integer> {
    
    public Book  findById(int bookId); 
}
