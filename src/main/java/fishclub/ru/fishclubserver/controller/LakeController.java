package fishclub.ru.fishclubserver.controller;

import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lake")
public class LakeController {

    @PostMapping
    public ResponseEntity<LakeResponseDto> createLake(
            @RequestBody LakeRequestDto request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
    
}
