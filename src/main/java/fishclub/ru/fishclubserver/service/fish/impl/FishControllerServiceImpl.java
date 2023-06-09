package fishclub.ru.fishclubserver.service.fish.impl;

import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.dto.fish.FishJournalDto;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.mapper.fish.FishMapper;
import fishclub.ru.fishclubserver.mapper.reference.FishReferenceMapper;
import fishclub.ru.fishclubserver.service.fish.FishControllerService;
import fishclub.ru.fishclubserver.service.fish.FishService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fishControllerService")
public class FishControllerServiceImpl implements FishControllerService {

    @Resource(name = "fishService")
    private FishService fishService;
    @Resource
    private FishMapper fishMapper;

    @Resource
    private FishReferenceMapper fishReferenceMapper;

    @Override
    public List<FishJournalDto> getJournal() {
        List<FishJournalEntity> result = fishService.getJournal();
        return fishMapper.mapToDto(result);
    }

    @Override
    public List<FishReferenceDto> getFishesReference() {
        List<Fish> allFishes = fishService.getAllFishes();
        return fishReferenceMapper.mapToDto(allFishes);
    }

    @Override
    public FishResponseDto createFish(FishRequestDto request) {
        Fish newFish = fishMapper.mapToEntity(request);
        newFish = fishService.createNewFish(newFish);
        return fishMapper.mapToDto(newFish);
    }

    @Override
    public FishResponseDto getFishById(String id) {
        Long fishId = Long.parseLong(id);
        Fish fish = fishService.getFishById(fishId);
        return fishMapper.mapToDto(fish);
    }

    @Override
    public FishResponseDto updateFishById(String id, FishRequestDto request) {
        Long updFishId = Long.parseLong(id);
        Fish updFish = fishService.getFishById(updFishId);
        Fish curFish = fishMapper.mapToEntity(request);
        fishService.updateFish(updFish, curFish);
        return fishMapper.mapToDto(updFish);
    }

    @Override
    public void deleteFishById(String id) {
        Long fishDeleteId = Long.parseLong(id);
        fishService.deleteFish(fishDeleteId);
    }
}
