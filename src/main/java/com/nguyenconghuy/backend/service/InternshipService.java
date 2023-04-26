package com.nguyenconghuy.backend.service;

import com.nguyenconghuy.backend.api.model.request.RegisInternRequest;
import com.nguyenconghuy.backend.api.model.response.RegisInternDTO;
import com.nguyenconghuy.backend.entity.RegisInternship;
import com.nguyenconghuy.backend.entity.Technology;
import com.nguyenconghuy.backend.repository.RegisInternshipRepository;
import com.nguyenconghuy.backend.repository.TechnologyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Service
public class InternshipService {
    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private RegisInternshipRepository regisInternshipRepository;

    private RegisInternship convertToEntity(RegisInternRequest regisInternRequest){
        RegisInternship regisInternship = new RegisInternship();
        regisInternship.setFullname(regisInternRequest.getFullname());
        regisInternship.setBirthday(regisInternRequest.getBirthday());
        regisInternship.setEmail(regisInternRequest.getEmail());
        regisInternship.setPhone(regisInternRequest.getPhone());
        regisInternship.setGender(regisInternRequest.getGender());
        regisInternship.setCity(regisInternRequest.getCity());
        regisInternship.setEducation(regisInternRequest.getEducation());
        regisInternship.setFaculty(regisInternRequest.getFaculty());
        regisInternship.setGraduayear(regisInternRequest.getGraduayear());
        regisInternship.setGPA(regisInternRequest.getGPA());
        regisInternship.setForeignlanguage(regisInternRequest.getForeignlanguage());
        regisInternship.setCertificate(regisInternRequest.getCertificate());
        regisInternship.setOtherskill(regisInternRequest.getOtherskill());
        regisInternship.setWroktime(regisInternRequest.getWroktime());
        regisInternship.setProfilelink(regisInternRequest.getProfilelink());
        regisInternship.setProfile(regisInternRequest.getProfile().getBytes(StandardCharsets.UTF_8));
        return regisInternship;
    }
    private RegisInternDTO convertToDTO(RegisInternship regisInternship){
        RegisInternDTO regisInternDTO = new RegisInternDTO();
        regisInternDTO.setId(regisInternship.getId());
        regisInternDTO.setFullname(regisInternship.getFullname());
        regisInternDTO.setBirthday(regisInternship.getBirthday());
        regisInternDTO.setEmail(regisInternship.getEmail());
        regisInternDTO.setPhone(regisInternship.getPhone());
        regisInternDTO.setGender(regisInternship.getGender());
        regisInternDTO.setCity(regisInternship.getCity());
        regisInternDTO.setEducation(regisInternship.getEducation());
        regisInternDTO.setFaculty(regisInternship.getFaculty());
        regisInternDTO.setGraduayear(regisInternship.getGraduayear());
        regisInternDTO.setGPA(regisInternship.getGPA());
        regisInternDTO.setForeignlanguage(regisInternship.getForeignlanguage());
        regisInternDTO.setCertificate(regisInternship.getCertificate());
        regisInternDTO.setOtherskill(regisInternship.getOtherskill());
        regisInternDTO.setWroktime(regisInternship.getWroktime());
        regisInternDTO.setProfilelink(regisInternship.getProfilelink());
        regisInternDTO.setProfile("intern/" + regisInternship.getId() + "/profile");
        regisInternDTO.setNameTechnology(regisInternship.getTechnology().getName());
        return regisInternDTO;
    }


    public RegisInternDTO saveInternship(RegisInternRequest regisInternRequest){
        //save vào database
        RegisInternship regisInternship = convertToEntity(regisInternRequest);
        Technology technology = technologyRepository.findById(regisInternRequest.getIdTechnology())
                .orElseThrow(() -> new RuntimeException("Technology không tìm thấy"));
        regisInternship.setTechnology(technology);
        RegisInternship saveregisInternship = regisInternshipRepository.save(regisInternship);
        //trả về DTO, hiển thị client
        return convertToDTO(saveregisInternship);
    }

    public RegisInternDTO getByIdInternship(UUID id){
        RegisInternship regisInternship = regisInternshipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("không tìm thấy id"));
        return convertToDTO(regisInternship);
    }

    public void deleteInternship(UUID id){
        regisInternshipRepository.deleteById(id);
    }

}
