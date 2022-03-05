package org.nextgencollege.nextgencollege.Impl;

import org.nextgencollege.nextgencollege.DTOs.BooksDTO;
import org.nextgencollege.nextgencollege.Entity.Books;
import org.nextgencollege.nextgencollege.Entity.BooksTracker;
import org.nextgencollege.nextgencollege.Repository.BooksRepository;
import org.nextgencollege.nextgencollege.Repository.BooksTackerRepository;
import org.nextgencollege.nextgencollege.Service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BooksImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;


    @Autowired
    BooksTackerRepository booksTackerRepository;

    public Books saveBooks(Books books) {

        String noOne = "-";

        books = Books.builder()
                .id(books.getId())
                .bookId(books.getBookId())
                .author(books.getAuthor())
                .category(books.getCategory())
                .holdersName(noOne)
                .isAvailable(true)
                .name(books.getName())
                .uniqueId(noOne)
                .build();

        log.info("Success " + "Data Inserted Successfully !!!");

        return booksRepository.save(books);
    }

    public Books updateBooks(BooksDTO booksDTO) {


        String noOne = "-";
        String bookId = booksDTO.getBookId();
        Books books = booksRepository.findBybookId(bookId);
        long id = books.getId();
        log.error("Book Id :" + books.getBookId());

        books = booksRepository.findById(id).get();
        log.error("ID : " + books.getId());

        books.setId(id);
        books.setHoldersName(booksDTO.getHoldersName());
        books.setUniqueId(booksDTO.getUniqueId());
        books.setAvailable(false);
        books.setTimeStamp(booksDTO.getTimeStamp());

        log.error("Step 1 Completed !!!!");

        booksRepository.save(books);

        BooksTracker booksTracker = BooksTracker.builder()
                .comments(noOne)
                .bookId(bookId)
                .name(booksDTO.getHoldersName())
                .uniqueId(booksDTO.getUniqueId())
                .build();

        booksTackerRepository.save(booksTracker);
        log.error("Step 2 Completed !!!!");

        log.info("Success " + " Book Name " + books.getName() + " SuccessFully Updated !!!!");
        return books;

    }


}
