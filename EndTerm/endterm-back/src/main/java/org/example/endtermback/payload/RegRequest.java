package org.example.endtermback.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    private String firstName;
    private String lastName;

}
