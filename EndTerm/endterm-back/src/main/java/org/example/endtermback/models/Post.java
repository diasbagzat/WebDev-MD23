package org.example.endtermback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "posts")
@Getter
@Setter

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title_rus", length = 10485760, columnDefinition = "TEXT")
    @Size(max =  1024)
    private String title;

    @Column(name = "created_date")
    private Date date;
    @Column(name = "article_rus", length = 10485760, columnDefinition = "TEXT")
    @Size(max =  10485760)
    private String article;


}
