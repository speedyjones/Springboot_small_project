package org.nextgencollege.nextgencollege.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class BooksTrackerDTO {

    private long id;
    private String bookId;
    private String name;
    private String uniqueId;
    private Date issuedAt;
    private Date submittedAt;
    private String comments;
}
