package com.nguyenconghuy.backend.api.controller;


import com.nguyenconghuy.backend.api.model.response.RegisJoinDTO;
import com.nguyenconghuy.backend.api.model.response.TechnologyDTO;
import com.nguyenconghuy.backend.service.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intro")
@CrossOrigin("http://localhost:3000/")
public class IntroController {

    @Autowired
    private IntroService introService;

    @GetMapping
    public List<TechnologyDTO> getAllTechnology(){
        return introService.getAllTechnology();
    }

    @PostMapping("new")
    public RegisJoinDTO saveRegisJoin(@RequestBody RegisJoinDTO regisJoinDTO){
        return introService.saveRegisJoin(regisJoinDTO);
    }

}
