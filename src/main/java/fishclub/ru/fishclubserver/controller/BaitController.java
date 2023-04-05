package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.bait.BaitRequestDto;
import fishclub.ru.fishclubserver.dto.bait.BaitResponseDto;
import fishclub.ru.fishclubserver.service.bait.BaitControllerService;
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
@RequestMapping(path = "/baits")
public class BaitController {

    @Resource(name = "baitControllerService")
    private BaitControllerService baitControllerService;

    @PostMapping
    public ResponseEntity<BaitResponseDto> createNewBait(
            @RequestBody BaitRequestDto request) {
        BaitResponseDto result = baitControllerService.createNewBait(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BaitResponseDto> getBaitById(
            @PathVariable("id") String baitId) {
        BaitResponseDto result = baitControllerService.getBaitById(baitId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaitResponseDto> updateById(
            @PathVariable("id") String baitId,
            @RequestBody BaitRequestDto request) {
        BaitResponseDto result = baitControllerService.updateById(baitId, request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBaitById(
            @PathVariable("id") String baitId) {
        baitControllerService.deleteBaitById(baitId);
    }
}
