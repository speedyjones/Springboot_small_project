package com.nextgencollege.nextgencollege.Repository;

import com.nextgencollege.nextgencollege.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {


    Books findBybookId(String bookId);
}
