package com.siva.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.demo.customException.RecordNotFoundException;
import com.siva.demo.model.Book;
import com.siva.demo.service.BookService;

@RestController
@RequestMapping("/books")

public class BooksController {
	private static final Logger Log = LoggerFactory.getLogger(BooksController.class);

	@Autowired
	BookService service;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {

		List<Book> list = service.getAllBooks();
		Log.info("GetAllBook >>size>>" + list.size());

		return new ResponseEntity<List<Book>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Book> createBooks(@RequestBody Book books) throws RecordNotFoundException {
		Book updated = service.createBook(books);
		return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);
	}

}
