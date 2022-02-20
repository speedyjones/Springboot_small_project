package com.nextgencollege.nextgencollege.Service;

import com.nextgencollege.nextgencollege.DTOs.BooksDTO;
import com.nextgencollege.nextgencollege.Entity.Books;


public interface BooksService {

    Books saveBooks(Books books);

    Books updateBooks(BooksDTO booksDTO);
}
