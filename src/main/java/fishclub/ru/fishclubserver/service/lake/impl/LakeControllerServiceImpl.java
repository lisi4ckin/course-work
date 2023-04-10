package fishclub.ru.fishclubserver.service.lake.impl;

import fishclub.ru.fishclubserver.dto.lake.LakeRequestDto;
import fishclub.ru.fishclubserver.dto.lake.LakeResponseDto;
import fishclub.ru.fishclubserver.entity.Lake;
import fishclub.ru.fishclubserver.mapper.lake.LakeMapper;
import fishclub.ru.fishclubserver.service.lake.LakeControllerService;
import fishclub.ru.fishclubserver.service.lake.LakeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("lakeControllerService")
public class LakeControllerServiceImpl implements LakeControllerService {

    @Resource(name = "lakeService")
    private LakeService lakeService;

    @Resource
    private LakeMapper lakeMapper;

    @Override
    public LakeResponseDto createNewLake(LakeRequestDto request) {
        Lake newLake = lakeMapper.mapToEntity(request);
        newLake = lakeService.createNewLake(newLake);
        return lakeMapper.mapToDto(newLake);
    }


    @Override
    public LakeResponseDto getLakeById(String id) {
        Lake result = lakeService.getLakeById(Long.parseLong(id));
        return lakeMapper.mapToDto(result);
    }

    @Override
    public LakeResponseDto updateLakeById(String id, LakeRequestDto request) {
        Lake updLake = lakeService.getLakeById(Long.parseLong(id));
        Lake curLake = lakeMapper.mapToEntity(request);
        lakeService.updateLake(updLake, curLake);
        return lakeMapper.mapToDto(updLake);
    }

    @Override
    public void deleteLakeById(String id) {
        lakeService.deleteLake(Long.parseLong(id));
    }
}
