package fishclub.ru.fishclubserver.service.bait;

import fishclub.ru.fishclubserver.dto.bait.BaitRequestDto;
import fishclub.ru.fishclubserver.dto.bait.BaitResponseDto;

public interface BaitControllerService {

    BaitResponseDto createNewBait(BaitRequestDto request);

    BaitResponseDto getBaitById(String baitId);

    BaitResponseDto updateById(String baitId, BaitRequestDto request);

    void deleteBaitById(String baitId);
}
