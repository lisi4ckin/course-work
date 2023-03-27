package fishclub.ru.fishclubserver.service.fish.impl;

import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.mapper.fish.FishMapper;
import fishclub.ru.fishclubserver.service.fish.FishControllerService;
import fishclub.ru.fishclubserver.service.fish.FishService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("fishControllerService")
public class FishControllerServiceImpl implements FishControllerService {

    @Resource(name = "fishService")
    private FishService fishService;
    @Resource
    private FishMapper fishMapper;

    @Override
    public FishResponseDto createFish(FishRequestDto request) {
        Fish newFish = fishMapper.mapToEntity(request);
        newFish = fishService.createNewFish(newFish);
        return fishMapper.mapToDto(newFish);
    }
}
