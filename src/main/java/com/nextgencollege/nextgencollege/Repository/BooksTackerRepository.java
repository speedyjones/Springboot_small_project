package com.nextgencollege.nextgencollege.Repository;

import com.nextgencollege.nextgencollege.Entity.BooksTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksTackerRepository extends JpaRepository<BooksTracker,Long> {


    BooksTracker findByBookId(String id);
}
