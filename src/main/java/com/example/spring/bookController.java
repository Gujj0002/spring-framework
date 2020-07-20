package com.example.spring;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest")
public class bookController {

    @Autowired
    bookRepository repository;


    @ApiOperation("Get all book from list, return all books")
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    // @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<book>> getAll() {
        return new ResponseEntity<Collection<book>>(repository.findAll(), HttpStatus.OK);
    }

  /*  @ApiOperation("Get one book from list, return one books by id")
    @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<book> getOne(@PathVariable Integer id) {
        book Book;
        Book = repository.findOne(id);
        return new ResponseEntity<book>(Book, HttpStatus.OK);
    }*/

    @ApiOperation("Create a book into list, return all books")
    @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOrAdd(@RequestBody(required = true) book Book) {
        repository.save(Book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Update a list, return all books")
    @PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody(required = true) book Book) {
        if (Book.getId() != null) {
           Book = repository.save(Book);
        } else {
            return createOrAdd(Book);
        }
        return new ResponseEntity<>(Book, HttpStatus.OK);
    }

   /* @ApiOperation("Delete book from list by id, return all books.")
    @DeleteMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
         repository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}
