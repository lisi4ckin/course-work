package fishclub.ru.fishclubserver.service.fishermen.imp;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.fishermen.FishermenMapper;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FishermenControllerServiceImpl implements FishermenControllerService {

    @Resource
    private FishermenService fishermenService;

    @Resource
    private FishermenMapper fishermenMapper;

    @Override
    public FishermenResponseDto createNewFishermen(FishermenRequestDto request) {
        Fishermen newFishermen = fishermenMapper.mapToEntity(request);
        newFishermen = fishermenService.createFishermen(newFishermen);
        return fishermenMapper.mapToDto(newFishermen);
    }
}
