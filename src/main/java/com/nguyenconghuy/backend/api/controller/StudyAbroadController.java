package com.nguyenconghuy.backend.api.controller;

import com.nguyenconghuy.backend.api.model.response.RegisSADTO;
import com.nguyenconghuy.backend.service.StudyAbroadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duhoc")
@CrossOrigin("http://localhost:3000/")
public class StudyAbroadController {

    @Autowired
    private StudyAbroadService studyAbroadService;


    @GetMapping
    public List<RegisSADTO> getAllRegisSA(){
        return studyAbroadService.getAllRegisSA();
    }

    @PostMapping("new")
    public RegisSADTO saveRegisSA(@RequestBody RegisSADTO regisSADTO){
        return studyAbroadService.saveRegisSA(regisSADTO);
    }
}
