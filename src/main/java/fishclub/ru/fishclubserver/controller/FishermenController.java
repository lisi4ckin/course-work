package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
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
@RequestMapping(path = "/fishermen")
public class FishermenController {

    @Resource

    private FishermenControllerService fishermenControllerService;

    @PostMapping
    public ResponseEntity<FishermenResponseDto> createNewFishermen(
            @RequestBody FishermenRequestDto request) {
        FishermenResponseDto result = fishermenControllerService.createNewFishermen(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FishermenResponseDto> getFishermanById(
            @PathVariable("id") String fishermanId) {
        return null;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FishermenResponseDto> updateFishermanById(
            @PathVariable("id") String fishermanId,
            @RequestBody FishermenRequestDto request) {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFishermanById(
            @PathVariable("id") String fishermanId) {

    }
}
