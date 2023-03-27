package fishclub.ru.fishclubserver.service.fish;

import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;

public interface FishControllerService {
    FishResponseDto createFish(FishRequestDto request);
}
