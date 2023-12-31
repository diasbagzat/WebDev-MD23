package org.example.endtermback.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
public class PostRequest {
    @NotNull
    private Long id;


    @NotNull
    @Size(max = 10485760)
    @Length(max = 10485760)
    private String title;

    @NotNull
    @Length(max = 10485760)
    @Size(max = 10485760)
    private String article;

    private Date date;

}
