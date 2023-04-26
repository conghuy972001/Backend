package com.nguyenconghuy.backend.api.controller;

import com.nguyenconghuy.backend.api.model.request.RegisInternRequest;
import com.nguyenconghuy.backend.api.model.response.RegisInternDTO;
import com.nguyenconghuy.backend.entity.RegisInternship;
import com.nguyenconghuy.backend.repository.RegisInternshipRepository;
import com.nguyenconghuy.backend.service.InternshipService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/intern")
@CrossOrigin("http://localhost:3000/")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;
    @Autowired
    private RegisInternshipRepository regisInternshipRepository;


    @PostMapping
    public RegisInternDTO saveInternship(@RequestBody RegisInternRequest regisInternRequest){
        return internshipService.saveInternship(regisInternRequest);
    }

    @PostMapping("/{id}/profile")
    public ResponseEntity<Void> uploadProfile(@PathVariable UUID id, @RequestParam("file")MultipartFile file){
        RegisInternship regisInternship = regisInternshipRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Không tim thấy intern"));
        if(file.getSize() > 30 * 1024 * 1024){
            throw new RuntimeException("không được quá 30mb");
        }
        try{
            regisInternship.setProfile(file.getBytes());
            regisInternshipRepository.save(regisInternship);
            return ResponseEntity.ok().build();
        }catch (IOException ex){
            throw new RuntimeException("Lưu file không thành công");
        }

    }

    @GetMapping("/{id}/profile")
    public ResponseEntity<Resource> downloadProfile(@PathVariable UUID id){
        RegisInternship regisInternship = regisInternshipRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Không tìm thấy Intern"));
        ByteArrayResource resource = new ByteArrayResource(regisInternship.getProfile());
        return ResponseEntity.ok()
                .contentLength(regisInternship.getProfile().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "profile" + "\"")
                .body(resource);
    }

    @GetMapping("/{id}")
    public RegisInternDTO getByIdInternship(@PathVariable UUID id){
        return internshipService.getByIdInternship(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInternship(@PathVariable UUID id){
        internshipService.deleteInternship(id);
    }





}
