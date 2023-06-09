package fishclub.ru.fishclubserver.service.fish;

import fishclub.ru.fishclubserver.dto.fish.FishJournalDto;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.fish.FishRequestDto;
import fishclub.ru.fishclubserver.dto.fish.FishResponseDto;

import java.util.List;

public interface FishControllerService {

    List<FishJournalDto> getJournal();

    List<FishReferenceDto> getFishesReference();

    FishResponseDto createFish(FishRequestDto request);

    FishResponseDto getFishById(String id);

    FishResponseDto updateFishById(String id, FishRequestDto request);

    void deleteFishById(String id);
}
