package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.fish.FishJournalDto;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.service.fish.FishControllerService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fishes")
public class FishController {

    @Resource(name = "fishControllerService")
    private FishControllerService fishControllerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FishJournalDto>> getFishes() {
        List<FishJournalDto> result = fishControllerService.getJournal();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/ref", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FishReferenceDto>> getFishesReference() {
        List<FishReferenceDto> result = fishControllerService.getFishesReference();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FishResponseDto> createFish(
            @RequestBody FishRequestDto request) {
        FishResponseDto result = fishControllerService.createFish(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<FishResponseDto> getFishById(
            @PathVariable("id") String fishId) {
        FishResponseDto result = fishControllerService.getFishById(fishId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<FishResponseDto> updateFishById(
            @PathVariable("id") String fishId,
            @RequestBody FishRequestDto request) {
        FishResponseDto result = fishControllerService.updateFishById(fishId, request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFishById(
            @PathVariable("id") String fishId) {
        fishControllerService.deleteFishById(fishId);
    }
}
