package com.userService.userService.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "user_profile")
public class UserProfile {

    private String id;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }
}
