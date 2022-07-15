package com.ookshop.application.tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    @Column
    private LocalDateTime creationDate;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private UserAccount userAccount;

    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private CompanyRole companyRole;
}
