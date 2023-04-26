package com.nguyenconghuy.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regis_internship")
public class RegisInternship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String fullname;
    private Date birthday;
    private int phone;
    private String email;
    private String gender;
    private String city;

    private String education;
    private String faculty;
    @Column(name = "graduation_year")
    private String graduayear;
    private String GPA;

    @Column(name = "foreign_language")
    private String foreignlanguage;
    @Column(name = "foreign_language_certificate")
    private String certificate;

    @JoinColumn(name = "id_technology")
    @ManyToOne(fetch = FetchType.LAZY)
    private Technology technology;
    @Column(name = "other_skill")
    private String otherskill;
    private String wroktime;

    @Column(name = "profile_link")
    private String profilelink;
    @Lob
    private byte[] profile;

}
