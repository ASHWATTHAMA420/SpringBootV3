package com.sample.payload.response;

import com.fasterxml.classmate.AnnotationOverrides;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;

}
