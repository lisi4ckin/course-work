package fishclub.ru.fishclubserver.service.fishermen.imp;

import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.fishermen.FishermenMapper;
import fishclub.ru.fishclubserver.service.fish.FishService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishermenControllerServiceImpl implements FishermenControllerService {

    @Resource(name = "fishService")
    private FishService fishService;
    @Resource
    private FishermenService fishermenService;

    @Resource
    private FishermenMapper fishermenMapper;

    @Override
    public FishermenResponseDto createNewFishermen(FishermenRequestDto request) {
        Fishermen newFishermen = fishermenMapper.mapToEntity(request, getFishesIds(request.getPreferencesFish()));
        newFishermen = fishermenService.createFishermen(newFishermen);
        return fishermenMapper.mapToDto(newFishermen);
    }

    @Override
    public FishermenResponseDto getFishermenById(String id) {
        Fishermen fishermen = fishermenService.getFishermenById(Long.parseLong(id));
        return fishermenMapper.mapToDto(fishermen);
    }

    @Override
    public FishermenResponseDto updateFishermen(String id, FishermenRequestDto request) {
        Fishermen updFishermen = fishermenService.getFishermenById(Long.parseLong(id));
        Fishermen curFishermen = fishermenMapper.mapToEntity(request, getFishesIds(request.getPreferencesFish()));
        fishermenService.updateFishermen(updFishermen, curFishermen);
        return fishermenMapper.mapToDto(updFishermen);
    }

    private List<Long> getFishesIds(List<FishReferenceDto> listReferences) {
        return listReferences.stream().map(item -> Long.parseLong(item.getId())).toList();
    }
}
