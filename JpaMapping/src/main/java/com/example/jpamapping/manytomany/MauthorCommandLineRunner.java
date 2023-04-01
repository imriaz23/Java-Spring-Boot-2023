package com.example.jpamapping.manytomany;

import com.example.jpamapping.manytomany.entity.MAuthor;
import com.example.jpamapping.manytomany.entity.MBook;
import com.example.jpamapping.manytomany.service.MauthorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * Test.
 */
@Service
public class MauthorCommandLineRunner implements CommandLineRunner {
  @Autowired
  MauthorService mAuthorService;

  @Override
  public void run(String... args) throws Exception {
    MAuthor author1 = new MAuthor();
    author1.setName(RandomStringUtils.randomAlphabetic(6, 8));
    MAuthor author2 = new MAuthor();
    author2.setName(RandomStringUtils.randomAlphabetic(6, 8));

    MBook book1 = new MBook();
    book1.getAuthors().add(author1);
    book1.getAuthors().add(author2);
    author1.getBooks().add(book1);
    author2.getBooks().add(book1);

    MBook book2 = new MBook();
    book2.getAuthors().add(author1);
    author1.getBooks().add(book2);

    MBook book3 = new MBook();
    book3.getAuthors().add(author2);
    author2.getBooks().add(book3);

    MBook book4 = new MBook();
    book4.getAuthors().add(author1);
    author1.getBooks().add(book4);
    book1.setTitle(RandomStringUtils.randomAlphanumeric(9, 18));
    book2.setTitle(RandomStringUtils.randomAlphanumeric(9, 18));
    book3.setTitle(RandomStringUtils.randomAlphanumeric(9, 18));
    book4.setTitle(RandomStringUtils.randomAlphanumeric(9, 18));

    mAuthorService.createAuthor(author1);
    mAuthorService.createAuthor(author2);

  }
}
