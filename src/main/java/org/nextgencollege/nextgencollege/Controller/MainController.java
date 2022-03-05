package org.nextgencollege.nextgencollege.Controller;

import org.nextgencollege.nextgencollege.DTOs.BooksDTO;
import org.nextgencollege.nextgencollege.DTOs.BooksTrackerDTO;
import org.nextgencollege.nextgencollege.Entity.Books;
import org.nextgencollege.nextgencollege.Impl.BooksImpl;
import org.nextgencollege.nextgencollege.Impl.BooksTrackerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/admin")
@CrossOrigin(value = "http://localhost:8080/")
public class MainController {


    @Autowired
    BooksImpl booksImpl;

    @Autowired
    BooksTrackerImpl booksTrackerImpl;

    @PostMapping("/insertBooks")
    public ResponseEntity<?> insertBooks(@RequestBody Books books) {
        Map<String, Object> insertBooks = new HashMap<>();
        insertBooks.put("Books", booksImpl.saveBooks(books));

        return new ResponseEntity<>(insertBooks, HttpStatus.OK);

    }


    @PostMapping("/updateBooks")
    public ResponseEntity<?> updateBooks(@RequestBody BooksDTO booksDTO) {
        Map<String, Object> updateBooks = new HashMap<>();
        updateBooks.put("Books", booksImpl.updateBooks(booksDTO));
        return new ResponseEntity<>(updateBooks, HttpStatus.OK);

    }


    @PostMapping("/updateTracker")
    public ResponseEntity<?> updateTracker(@RequestBody BooksTrackerDTO booksTracker) {
        Map<String, Object> updateTracker = new HashMap<>();
        updateTracker.put("Books", booksTrackerImpl.updateBooksTracker(booksTracker));
        return new ResponseEntity<>(updateTracker, HttpStatus.OK);

    }


}
