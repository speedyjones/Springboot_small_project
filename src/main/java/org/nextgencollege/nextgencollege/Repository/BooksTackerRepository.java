package org.nextgencollege.nextgencollege.Repository;

import org.nextgencollege.nextgencollege.Entity.BooksTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksTackerRepository extends JpaRepository<BooksTracker,Long> {


    BooksTracker findByBookId(String id);
}
