package com.nguyenconghuy.backend.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisInternRequest {

    private String fullname;
    private Date birthday;
    private int phone;
    private String email;
    private String gender;
    private String city;

    private String education;
    private String faculty;

    private String graduayear;
    private String GPA;


    private String foreignlanguage;
    private String certificate;

    private Long idTechnology;
    private String otherskill;
    private String wroktime;


    private String profilelink;

    private String profile;
}
