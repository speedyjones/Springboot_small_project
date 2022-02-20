package com.nextgencollege.nextgencollege.DTOs;

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
public class BooksDTO {


    private long id;
    private String name;
    private String bookId;
    private String author;
    private String category;
    private boolean isAvailable;
    private String HoldersName;
    private String uniqueId;
    private Date TimeStamp;

}
