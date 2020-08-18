package com.bikash.bikashBackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UserDto {

    private Long id;
    @NotEmpty(message = "User Name is Mandatory")
    private String username;
    @NotEmpty(message = "You Have To Enter The Password")
    @Size(min = 8, max = 20, message = "Password length should be in between 8 to 20")
    @JsonProperty
    private String password;
    @AssertTrue
    private boolean isMerchant;

    @DecimalMin("1.00")
    private double openingBalance;
    @Min(value = 10, message = "Nid length should be 10 or more")
    @Max(value = 17, message = "Nid length not more then 17")
    private Long nid;
    @NotBlank(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid Email Pattern")
    private String email;
    @Pattern(regexp = "^(?:\\+?88)?01[135-9]\\d{8}$", message = "invalid mobile number.")
    @Size(max = 11, message = "digits should be 11")
    private String phone;


}
