package com.sample.payload.response;

import com.sample.model.Role;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String firstname;
    private String lastname;
    private String email;
    private Role role;

}
