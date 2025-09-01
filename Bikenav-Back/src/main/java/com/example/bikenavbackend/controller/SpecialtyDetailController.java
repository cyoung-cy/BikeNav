package com.example.bikenavbackend.controller;

import com.example.bikenavbackend.dto.response.SpecialtyDetailResponseDTO;
import com.example.bikenavbackend.service.SpecialtyDetailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/villages")
public class SpecialtyDetailController {

    private final SpecialtyDetailService specialtyDetailService;

    public SpecialtyDetailController(SpecialtyDetailService specialtyDetailService) {
        this.specialtyDetailService = specialtyDetailService;
    }

    @GetMapping("/{villageId}/specialties/{type}/{id}")
    public ApiResult<SpecialtyDetailResponseDTO> getSpecialtyDetail(
            @PathVariable Integer villageId,
            @PathVariable String type,
            @PathVariable Integer id) {
        try {
            SpecialtyDetailResponseDTO detail = specialtyDetailService.getSpecialtyDetail(villageId, type, id);
            return new ApiResult<>(true, detail, "마을 특화상품 상세 조회 성공");
        } catch (IllegalArgumentException e) {
            return new ApiResult<>(false, null, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResult<>(false, null, "서버 오류가 발생했습니다.");
        }
    }
}
