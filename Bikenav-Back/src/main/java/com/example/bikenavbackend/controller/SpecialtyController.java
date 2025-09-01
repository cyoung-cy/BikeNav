package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.SpecialtyListResponseDTO;
import com.example.bikenavbackend.service.SpecialtyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/villages")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @GetMapping("/specialties")
    public ResponseEntity<?> getSpecialties() {
        SpecialtyListResponseDTO responseDTO = specialtyService.getAllSpecialties();
        return ResponseEntity.ok(
                new ApiResult<>(true, responseDTO, "마을 특화상품 목록 조회 성공")
        );
    }
}
