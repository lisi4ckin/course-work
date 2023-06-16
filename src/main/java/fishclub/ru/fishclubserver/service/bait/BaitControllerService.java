package fishclub.ru.fishclubserver.service.bait;

import fishclub.ru.fishclubserver.dto.bait.BaitRequestDto;
import fishclub.ru.fishclubserver.dto.bait.BaitResponseDto;
import fishclub.ru.fishclubserver.dto.bait.BaitJournalDto;
import fishclub.ru.fishclubserver.dto.bait.BaitReferenceDto;

import java.util.List;

public interface BaitControllerService {
    List<BaitJournalDto> getJournal();

    List<BaitReferenceDto> getBaitsReference();

    BaitResponseDto createNewBait(BaitRequestDto request);

    BaitResponseDto getBaitById(String baitId);

    BaitResponseDto updateById(String baitId, BaitRequestDto request);

    void deleteBaitById(String baitId);
}
