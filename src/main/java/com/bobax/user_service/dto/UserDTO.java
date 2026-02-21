package com.bobax.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String fullName;
    private String phone;
    private String address;
    private String role;
    private LocalDateTime createdAt;
    private Boolean enabled;
    
}