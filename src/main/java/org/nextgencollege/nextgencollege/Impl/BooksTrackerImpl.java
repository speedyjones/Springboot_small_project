package org.nextgencollege.nextgencollege.Impl;

import org.nextgencollege.nextgencollege.DTOs.BooksTrackerDTO;
import org.nextgencollege.nextgencollege.Entity.Books;
import org.nextgencollege.nextgencollege.Entity.BooksTracker;
import org.nextgencollege.nextgencollege.Repository.BooksRepository;
import org.nextgencollege.nextgencollege.Repository.BooksTackerRepository;
import org.nextgencollege.nextgencollege.Service.BooksTrackerService;
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
