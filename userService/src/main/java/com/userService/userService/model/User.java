package com.userService.userService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$")
    @NotBlank
    private String mobile;

    @NotBlank
    private String password;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private Boolean is_active = true;
    private Boolean sms_notification_active = true;
    private Boolean email_notification_active = true;

    public User() {
    }

    public User(Long id, String email, String mobile, String password, LocalDateTime createAt, LocalDateTime updateAt) {
        this.id = id;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void onCreate() {
        createAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }

    // Implementing UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can customize this part based on your role/authority setup
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return is_active;
    }

    public void setEmail(String email) {
        setEmail(email);
    }

    public void setMobile(String mobile) {
        setMobile(mobile);
    }

    public void setPassword(String password) {
        setPassword(password);
    }
    // Getters and setters...
}
