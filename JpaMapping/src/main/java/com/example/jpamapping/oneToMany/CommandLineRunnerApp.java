package com.example.jpamapping.oneToMany;

import com.example.jpamapping.oneToMany.entities.Author;
import com.example.jpamapping.oneToMany.entities.Book;
import com.example.jpamapping.oneToMany.services.AuthorService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class CommandLineRunnerApp implements CommandLineRunner {
  @Autowired
  AuthorService authorService;

  @Override
  public void run(String... args) throws Exception {
    Author author = new Author();
    author.setName(RandomStringUtils.randomAlphabetic(5, 9));
    for (int i = 0; i < 5; i++) {
      Book book = new Book();
      book.setTitle(RandomStringUtils.randomAlphabetic(5, 9));
      book.setAuthor(author);
      author.getBooks().add(book);
    }
    authorService.saveAuthor(author);
  }
}
