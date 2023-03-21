package fishclub.ru.fishclubserver.controller.fishermen;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
