package com.example.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest")
public class bookController {

    List<book> books = bookRepository.BOOKS;
    Map<Integer, book> IntegerBookMap = bookRepository.bookMap;


    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<book>> getAll(){
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<book> getOne(@PathVariable  Integer id){
        book Book = IntegerBookMap.get(id);
       return new ResponseEntity<book>(Book, HttpStatus.OK);
    }
    @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrAdd(@RequestBody(required = true) book Book){
        books.add(Book);
        IntegerBookMap.put(Book.getId(), Book);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
