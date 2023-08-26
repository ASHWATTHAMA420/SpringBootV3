package com.sample.payload.request;

import com.sample.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignupRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    public Role role;
}
