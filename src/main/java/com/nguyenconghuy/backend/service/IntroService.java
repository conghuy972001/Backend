package com.nguyenconghuy.backend.service;

import com.nguyenconghuy.backend.api.model.response.RegisJoinDTO;
import com.nguyenconghuy.backend.common.exception.ResourceNotFoundException;
import com.nguyenconghuy.backend.api.model.response.TechnologyDTO;
import com.nguyenconghuy.backend.entity.Technology;
import com.nguyenconghuy.backend.entity.RegisJoin;
import com.nguyenconghuy.backend.repository.RegisJoinRepository;
import com.nguyenconghuy.backend.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IntroService {

    @Autowired
    private TechnologyRepository technologyRepository;
    @Autowired
    private RegisJoinRepository regisJoinRepository;


    public List<TechnologyDTO> getAllTechnology(){
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TechnologyDTO getByIDTechnology(Long id){
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy" + id));
        return convertToDTO(technology);
    }

    public TechnologyDTO saveTechnology(TechnologyDTO technologyDTO) {
        Technology technology = convertToEntity(technologyDTO);
        Technology savedTechnology = technologyRepository.save(technology);
        return convertToDTO(savedTechnology);
    }
    public void deleteTechnology(Long id) {
        technologyRepository.deleteById(id);
    }

    private TechnologyDTO convertToDTO(Technology technology) {
        TechnologyDTO technologyDTO = new TechnologyDTO();
        technologyDTO.setId(technology.getId());
        technologyDTO.setName(technology.getName());
        return technologyDTO;
    }

    private Technology convertToEntity(TechnologyDTO technologyDTO) {
        Technology technology = new Technology();
        technology.setId(technologyDTO.getId());
        technology.setName(technologyDTO.getName());
        return technology;
    }





    public List<RegisJoinDTO> getAllRegisJoin(){
        List<RegisJoin> regisJoins = regisJoinRepository.findAll();
        return regisJoins.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RegisJoinDTO getByIdRegisJoin(UUID id) {
        RegisJoin regisJoin = regisJoinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tim thấy " + id));
        return convertToDTO(regisJoin);
    }

    public RegisJoinDTO saveRegisJoin(RegisJoinDTO regisJoinDTO) {
        RegisJoin regisJoin = convertToEntity(regisJoinDTO);
        Technology technology = technologyRepository.findById(regisJoinDTO.getIdTechnology())
                .orElseThrow(() -> new RuntimeException("Technology không tìm thấy"));
        regisJoin.setTechnology(technology);
        RegisJoin saveRegisJoin = regisJoinRepository.save(regisJoin);
        return convertToDTO(saveRegisJoin);

//        regisJoin.setId(regisJoinDTO.getId());
//        regisJoin.setFullname(regisJoinDTO.getFullname());
//        regisJoin.setPhone(regisJoinDTO.getPhone());
//        regisJoin.setEmail(regisJoinDTO.getEmail());
//        regisJoin.setWorkaddress(regisJoinDTO.getWorkaddress());
//        regisJoin.setWorktime(regisJoinDTO.getWorktime());
//        return regisJoinRepository.save(regisJoin);
    }



    public void deleteRegisJoin(UUID id){
        regisJoinRepository.deleteById(id);
    }

    private RegisJoinDTO convertToDTO(RegisJoin regisJoin){
        RegisJoinDTO regisJoinDTO = new RegisJoinDTO();
        regisJoinDTO.setId(regisJoin.getId());
        regisJoinDTO.setFullname(regisJoin.getFullname());
        regisJoinDTO.setPhone(regisJoin.getPhone());
        regisJoinDTO.setEmail(regisJoin.getEmail());
        regisJoinDTO.setIdTechnology(regisJoin.getTechnology().getId());
        regisJoinDTO.setWorkaddress(regisJoin.getWorkaddress());
        regisJoinDTO.setWorktime(regisJoin.getWorktime());
        return regisJoinDTO;
    }

    private RegisJoin convertToEntity(RegisJoinDTO regisJoinDTO){
        RegisJoin regisJoin = new RegisJoin();
        regisJoin.setId(regisJoinDTO.getId());
        regisJoin.setFullname(regisJoinDTO.getFullname());
        regisJoin.setPhone(regisJoinDTO.getPhone());
        regisJoin.setEmail(regisJoinDTO.getEmail());
        regisJoin.setWorkaddress(regisJoinDTO.getWorkaddress());
        regisJoin.setWorktime(regisJoinDTO.getWorktime());
        return regisJoin;
    }
}
