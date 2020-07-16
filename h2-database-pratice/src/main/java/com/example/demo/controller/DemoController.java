package com.example.demo.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.request.AddBookReq;
import com.example.demo.service.BookService;

@Controller
public class DemoController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/add/book", method = RequestMethod.PUT)
    public ResponseEntity<?> addBook(@RequestBody AddBookReq addBookReq) {
        bookService.saveOrUpdate(addBookReq);
        return ResponseEntity.status(HttpStatus.SC_OK).body("Success");
    }
}
