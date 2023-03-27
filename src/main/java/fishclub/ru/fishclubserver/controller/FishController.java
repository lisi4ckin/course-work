package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.service.fish.FishControllerService;
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
@RequestMapping("/fishes")
public class FishController {

    @Resource(name = "fishControllerService")
    private FishControllerService fishControllerService;

    @PostMapping
    public ResponseEntity<FishResponseDto> createFish(
            @RequestBody FishRequestDto request) {
        FishResponseDto result = fishControllerService.createFish(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<FishResponseDto> getFishById(
            @PathVariable("id") String fishId) {
        return null;
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<FishResponseDto> updateFishById(
            @PathVariable("id") String fishId,
            @RequestBody FishRequestDto request) {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFishById(
            @PathVariable("id") String fishId) {

    }
}
