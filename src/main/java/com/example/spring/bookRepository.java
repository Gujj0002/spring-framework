package com.example.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class bookRepository {

    public static List<book> BOOKS = new ArrayList<>();
    public static Map<Integer, book> bookMap = new HashMap<>();

    static {
        BOOKS.add(new book(1001, "Iron Man"));
        BOOKS.add(new book(1002, "Captain America"));
        BOOKS.add(new book(1003, "Black Widow"));
        BOOKS.add(new book(1004, "Black Panther"));
        BOOKS.add(new book(1005, "The Thor"));

        for (book books : BOOKS) {
            bookMap.put(books.getId(), books);
        }
    }
}
