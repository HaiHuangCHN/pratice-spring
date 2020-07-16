package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.DataProvider;
import com.example.demo.entity.Book;
import com.example.demo.model.request.AddBookReq;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private DataProvider dataProvider;

    @Override
    public List<Book> findAll() {
        return dataProvider.findAll();
    }

    public List<Book> findSmilarTitleBook(String title) throws InterruptedException {
        return dataProvider.findSmilarTitleBook(title);
    }

    @Override
    public Book saveOrUpdate(AddBookReq addBookRequest) {
        Book book = new Book();
        LocalDateTime now = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setIsbn(addBookRequest.getIsbn());
        book.setPrice(addBookRequest.getPrice());
        book.setAmount(addBookRequest.getAmount());
        book.setShortDesc(addBookRequest.getShortDesc());
        book.setLongDesc(addBookRequest.getLongDesc());
        book.setCreatedAt(now);
        book.setUpdatedAt(now);
        return dataProvider.saveOrUpdate(book, addBookRequest.getTitle());
    }

}
