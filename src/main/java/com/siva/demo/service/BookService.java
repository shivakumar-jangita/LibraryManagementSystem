package com.siva.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.demo.customException.RecordNotFoundException;
import com.siva.demo.model.Admin;
import com.siva.demo.model.Book;
import com.siva.demo.repository.BookRepos;

@Service
public class BookService {

	@Autowired
	BookRepos repos;

	public List<Book> getAllBooks() {
		List<Book> bookList = repos.findAll();

		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<Book>();
		}
	}

	public Book createBook(Book entity) throws RecordNotFoundException {
		Optional<Book> books = repos.findById(entity.getId());

		if (books.isPresent()) {
			Book newEntity = books.get();
			newEntity.setBookName(entity.getBookName());
			newEntity.setTitle(entity.getTitle());
			newEntity.setAuthor(entity.getAuthor());
			newEntity.setPublisher(entity.getPublisher());
			newEntity.setStatus(entity.getStatus());
			newEntity.setReturnDate(entity.getReturnDate());
			return newEntity;
		} else {
			entity = repos.save(entity);

			return entity;
		}
	}


}
