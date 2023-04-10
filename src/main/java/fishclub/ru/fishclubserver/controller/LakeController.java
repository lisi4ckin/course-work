package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;
import fishclub.ru.fishclubserver.service.lake.LakeControllerService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lake")
public class LakeController {

    @Resource(name = "lakeControllerService")
    private LakeControllerService lakeControllerService;

    @PostMapping
    public ResponseEntity<LakeResponseDto> createLake(
            @RequestBody LakeRequestDto request) {
        LakeResponseDto result = lakeControllerService.createNewLake(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LakeResponseDto> getFishById(
            @PathVariable("id") String lakeId) {
        LakeResponseDto result = lakeControllerService.getLakeById(lakeId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<LakeResponseDto> updateFishById(
            @PathVariable("id") String lakeId,
            @RequestBody LakeRequestDto request) {
        LakeResponseDto result = lakeControllerService.updateLakeById(lakeId, request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFishById(
            @PathVariable("id") String lakeId) {
        lakeControllerService.deleteLakeById(lakeId);
    }
    
}
