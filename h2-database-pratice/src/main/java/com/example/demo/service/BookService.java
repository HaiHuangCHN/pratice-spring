package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.model.request.AddBookReq;

@Service
public interface BookService {

    public List<Book> findAll();

    public List<Book> findSmilarTitleBook(String title) throws InterruptedException;

    public Book saveOrUpdate(AddBookReq addBookRequest);

}
