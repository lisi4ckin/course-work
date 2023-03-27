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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        Fishermen newFishermen = fishermenMapper.mapToEntity(request);
        newFishermen.setPreferencesFishes(fishService.getFishesByIds(getFishesIds(request.getPreferencesFish())));
        newFishermen = fishermenService.createFishermen(newFishermen);
        return fishermenMapper.mapToDto(newFishermen);
    }

    private List<Long> getFishesIds(List<FishReferenceDto> listReferences) {
        return listReferences.stream().map(item -> Long.parseLong(item.getId())).toList();
    }
}
