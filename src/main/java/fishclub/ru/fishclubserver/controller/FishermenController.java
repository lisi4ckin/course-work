package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fishermen")
public class FishermenController {

    @Autowired
    private FishermenControllerService fishermenControllerService;

    @Autowired
    private FishermenReportService reportService;

    @PostMapping
    public ResponseEntity<FishermenResponseDto> createNewFishermen(
            @RequestBody FishermenRequestDto request) {
        FishermenResponseDto result = fishermenControllerService.createNewFishermen(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FishermenListResultDto>> getFishermenList() {
        List<FishermenListResultDto> result = fishermenControllerService.getFishermenList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FishermenResponseDto> getFishermanById(
            @PathVariable("id") String fishermanId) {
        FishermenResponseDto result = fishermenControllerService.getFishermenById(fishermanId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FishermenResponseDto> updateFishermanById(
            @PathVariable("id") String fishermanId,
            @RequestBody FishermenRequestDto request) {
        FishermenResponseDto result = fishermenControllerService.updateFishermen(fishermanId, request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteFishermanById(
            @PathVariable("id") String fishermanId) {
        fishermenControllerService.deleteFishermenById(fishermanId);
    }

    @GetMapping(path = "/report")
    @ResponseBody
    public ResponseEntity<Resource> getReport() {
        Resource reportFile = reportService.getFishermenReport();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                        reportFile.getFilename() + "\"")
                .body(reportFile);
    }
}
