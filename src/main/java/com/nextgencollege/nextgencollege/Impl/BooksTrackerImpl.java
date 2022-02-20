package com.nextgencollege.nextgencollege.Impl;

import com.nextgencollege.nextgencollege.DTOs.BooksTrackerDTO;
import com.nextgencollege.nextgencollege.Entity.Books;
import com.nextgencollege.nextgencollege.Entity.BooksTracker;
import com.nextgencollege.nextgencollege.Repository.BooksRepository;
import com.nextgencollege.nextgencollege.Repository.BooksTackerRepository;
import com.nextgencollege.nextgencollege.Service.BooksTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BooksTrackerImpl implements BooksTrackerService {

    @Autowired
    BooksTackerRepository booksTackerRepository;

    @Autowired
    BooksRepository booksRepository;


    @Override
    public BooksTracker updateBooksTracker(BooksTrackerDTO booksTrackerDTO) throws NullPointerException {

        String id = booksTrackerDTO.getBookId();

        String noOne = "-";
        BooksTracker booksTracker = booksTackerRepository.findByBookId(id);
        booksTracker.setComments(booksTrackerDTO.getComments());


        Books books = booksRepository.findBybookId(id);
        books.setAvailable(true);
        books.setHoldersName(noOne);
        books.setUniqueId(noOne);

        booksRepository.saveAndFlush(books);

        log.info("Success" + " Record " + id + " Has Been Updated SuccessFully !!!!");

        return booksTackerRepository.saveAndFlush(booksTracker);

    }
}
