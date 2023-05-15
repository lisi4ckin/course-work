package fishclub.ru.fishclubserver.service.fishermen.imp;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.fishermen.FishermenMapper;
import fishclub.ru.fishclubserver.service.fish.FishService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenControllerService;
import fishclub.ru.fishclubserver.service.fishermen.FishermenService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishermenControllerServiceImpl implements FishermenControllerService {

    private final Logger LOG = LoggerFactory.getLogger(FishermenControllerServiceImpl.class);

    @Resource(name = "fishService")
    private FishService fishService;
    @Resource
    private FishermenService fishermenService;
    @Resource
    private FishermenMapper fishermenMapper;

    @Override
    public List<FishermenListResultDto> getFishermenList() {
        LOG.info("operation=FishermenControllerServiceImpl.getFishermenList, action=start");
        List<FishermenJournalEntity> fishermen = fishermenService.getFishermenJournalList();
        LOG.info("operation=FishermenControllerServiceImpl.getFishermenList, action=end, params={}", fishermen);
        return fishermenMapper.mapToDto(fishermen);
    }

    @Override
    public FishermenResponseDto createNewFishermen(FishermenRequestDto request) {
        Fishermen newFishermen = fishermenMapper.mapToEntity(request,
                (request.getPreferencesFish() != null) ? getFishesIds(request.getPreferencesFish()) : null);
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
        Fishermen curFishermen = fishermenMapper.mapToEntity(request,
                (request.getPreferencesFish() != null) ? getFishesIds(request.getPreferencesFish()) : null);
        fishermenService.updateFishermen(updFishermen, curFishermen);
        return fishermenMapper.mapToDto(updFishermen);
    }

    @Override
    public void deleteFishermenById(String id) {
        fishermenService.deleteFishermen(Long.parseLong(id));
    }

    private List<Long> getFishesIds(List<FishReferenceDto> listReferences) {
        return listReferences.stream().map(item -> Long.parseLong(item.getId())).toList();
    }
}
