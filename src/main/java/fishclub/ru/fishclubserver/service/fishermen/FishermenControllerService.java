package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;
import fishclub.ru.fishclubserver.dto.fishermen.list.FishermenListResultDto;

import java.util.List;

public interface FishermenControllerService {
    List<FishermenListResultDto> getFishermenList();

    FishermenResponseDto createNewFishermen(FishermenRequestDto request);

    FishermenResponseDto getFishermenById(String id);

    FishermenResponseDto updateFishermen(String id, FishermenRequestDto request);

    void deleteFishermenById(String id);
}
