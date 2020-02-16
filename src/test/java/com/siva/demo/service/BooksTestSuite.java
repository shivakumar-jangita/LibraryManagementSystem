package com.siva.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.siva.demo.LibraryDemoApplication;
import com.siva.demo.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryDemoApplication.class)

public class BooksTestSuite {
	private static final Logger Log = LoggerFactory.getLogger(BooksTestSuite.class);
	@Autowired
	BookService service;

	@Test
	public void testAllBooksData() {
		List<Book> getAllData = null;
		try {
			getAllData = service.getAllBooks();
			Log.info("All Books Data" + getAllData.toString());
		} catch (Exception e) {

		}

	}

}
