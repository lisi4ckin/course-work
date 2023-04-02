package fishclub.ru.fishclubserver.service.fish;

import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;

public interface FishControllerService {
    FishResponseDto createFish(FishRequestDto request);

    FishResponseDto getFishById(String id);

    FishResponseDto updateFishById(String id, FishRequestDto request);

    void deleteFishById(String id);
}
