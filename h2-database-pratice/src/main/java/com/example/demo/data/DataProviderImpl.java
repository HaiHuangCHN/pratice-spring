package com.example.demo.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Component
public class DataProviderImpl implements DataProvider {

    private static final Logger logger = LoggerFactory.getLogger(DataProviderImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Cacheable("book")
    @Override
    public List<Book> findSmilarTitleBook(String title) throws InterruptedException {
        simulateSlowService();
        return bookRepository.findSmilarTitleBook(title);
    }

    private void simulateSlowService() throws InterruptedException {
        long time = 5000L;
        Thread.sleep(time);
    }

    @Override
    public Book saveOrUpdate(Book book, String title) {
        return bookRepository.findByTitle(title).map(x -> {// update
            x.setAuthor(book.getAuthor());
            x.setIsbn(book.getTitle());
            x.setPrice(book.getPrice());
            x.setAmount(book.getAmount());
            x.setShortDesc(book.getShortDesc());
            x.setLongDesc(book.getLongDesc());
            return bookRepository.save(x);
        }).orElseGet(() -> {// add
            return bookRepository.save(book);
        });
    }

}