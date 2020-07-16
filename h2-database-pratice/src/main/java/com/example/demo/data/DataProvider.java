package com.example.demo.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Book;

@Component
public interface DataProvider {

    public List<Book> findAll();

    public List<Book> findSmilarTitleBook(String title) throws InterruptedException;

    public Book saveOrUpdate(Book book, String title);

}