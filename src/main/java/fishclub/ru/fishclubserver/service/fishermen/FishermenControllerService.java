package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.dto.fishermen.FishermenRequestDto;
import fishclub.ru.fishclubserver.dto.fishermen.FishermenResponseDto;

public interface FishermenControllerService {
    FishermenResponseDto createNewFishermen(FishermenRequestDto request);

    FishermenResponseDto getFishermenById(String id);

    FishermenResponseDto updateFishermen(String id, FishermenRequestDto request);
}
