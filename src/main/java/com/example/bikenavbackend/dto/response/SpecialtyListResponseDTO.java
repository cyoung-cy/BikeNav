package com.example.bikenavbackend.dto.response;

import java.util.List;

public class SpecialtyListResponseDTO {
    private List<SpecialtyResponseDTO> specialties;

    public SpecialtyListResponseDTO() {}

    public SpecialtyListResponseDTO(List<SpecialtyResponseDTO> specialties) {
        this.specialties = specialties;
    }

    public List<SpecialtyResponseDTO> getSpecialties() { return specialties; }
    public void setSpecialties(List<SpecialtyResponseDTO> specialties) { this.specialties = specialties; }
}
