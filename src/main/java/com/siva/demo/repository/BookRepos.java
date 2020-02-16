package com.siva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siva.demo.model.Book;

@Repository
public interface BookRepos extends JpaRepository<Book, Long> {

}
