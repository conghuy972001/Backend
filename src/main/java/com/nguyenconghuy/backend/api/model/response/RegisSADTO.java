package com.nguyenconghuy.backend.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisSADTO {
    private UUID id;
    private String name;
    private String phone;
    private String email;
    private String city;
}
