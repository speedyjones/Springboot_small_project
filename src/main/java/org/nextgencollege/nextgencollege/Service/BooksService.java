package org.nextgencollege.nextgencollege.Service;

import org.nextgencollege.nextgencollege.DTOs.BooksDTO;
import org.nextgencollege.nextgencollege.Entity.Books;


public interface BooksService {

    Books saveBooks(Books books);

    Books updateBooks(BooksDTO booksDTO);
}
