package com.nguyenconghuy.backend.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisInternDTO {

    private UUID id;
    private String fullname;
    private Date birthday;
    private int phone;
    private String email;
    private String gender;
    private String city;

    private String education;
    private String faculty;

    private String Graduayear;
    private String GPA;


    private String Foreignlanguage;
    private String certificate;

    private String nameTechnology;
    private String otherskill;
    private String wroktime;


    private String profilelink;

    private String profile;

}
