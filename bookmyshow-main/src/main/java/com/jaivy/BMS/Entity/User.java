package com.jaivy.BMS.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Table(name = "Users")
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_number")   // ← space hatao, nullable remove karo
    private String phoneNumber;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }
}