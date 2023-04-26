package com.nguyenconghuy.backend.service;

import com.nguyenconghuy.backend.api.model.response.RegisSADTO;
import com.nguyenconghuy.backend.entity.RegisSA;
import com.nguyenconghuy.backend.common.exception.ResourceNotFoundException;
import com.nguyenconghuy.backend.repository.RegisSARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudyAbroadService {

    @Autowired
    private RegisSARepository regisSARepository;

    public List<RegisSADTO> getAllRegisSA(){
        List<RegisSA> regisSAS = regisSARepository.findAll();
        return regisSAS.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RegisSADTO getByIDRegisSA(UUID id){
        RegisSA regisSA = regisSARepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy" + id));
        return convertToDTO(regisSA);
    }

    public RegisSADTO saveRegisSA(RegisSADTO regisSADTO) {
        RegisSA regisSA = convertToEntity(regisSADTO);
        RegisSA savedRegisSA = regisSARepository.save(regisSA);
        return convertToDTO(savedRegisSA);
    }

    public void deleteRegisSA(UUID id) {
        regisSARepository.deleteById(id);
    }

    private RegisSADTO convertToDTO (RegisSA regisSA){
        RegisSADTO regisSADTO = new RegisSADTO();
        regisSADTO.setId(regisSA.getId());
        regisSADTO.setName(regisSA.getName());
        regisSADTO.setEmail(regisSA.getEmail());
        regisSADTO.setPhone(regisSA.getPhone());
        regisSADTO.setCity(regisSA.getCity());
        return regisSADTO;
    }

    private RegisSA convertToEntity (RegisSADTO regisSADTO){
        RegisSA regisSA = new RegisSA();
        regisSA.setId(regisSADTO.getId());
        regisSA.setName(regisSADTO.getName());
        regisSA.setCity(regisSADTO.getCity());
        regisSA.setPhone(regisSADTO.getPhone());
        regisSA.setEmail(regisSADTO.getEmail());
        return regisSA;
    }
}
