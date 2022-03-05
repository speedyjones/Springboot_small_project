package org.nextgencollege.nextgencollege.Repository;

import org.nextgencollege.nextgencollege.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {


    Books findBybookId(String bookId);
}
