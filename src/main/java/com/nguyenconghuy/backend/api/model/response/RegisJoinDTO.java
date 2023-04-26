package com.nguyenconghuy.backend.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisJoinDTO {
    private UUID id;
    private String fullname;
    private String phone;
    private String email;
    private Long idTechnology;
    private String workaddress;
    private String worktime;
}
