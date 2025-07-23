package com.shlok.CodeLocker.dto;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class RegisterRequest {
    private String username;
    private String password;
}
