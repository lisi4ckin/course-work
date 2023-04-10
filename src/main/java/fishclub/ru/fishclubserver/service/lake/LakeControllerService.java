package fishclub.ru.fishclubserver.service.lake;

import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;

public interface LakeControllerService {

    LakeResponseDto createNewLake(LakeRequestDto request);

    LakeResponseDto getLakeById(String id);

    LakeResponseDto updateLakeById(String id, LakeRequestDto request);

    void deleteLakeById(String id);
}
