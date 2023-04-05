package fishclub.ru.fishclubserver.service.bait.impl;

import fishclub.ru.fishclubserver.dto.bait.BaitRequestDto;
import fishclub.ru.fishclubserver.dto.bait.BaitResponseDto;
import fishclub.ru.fishclubserver.entity.Bait;
import fishclub.ru.fishclubserver.mapper.bait.BaitMapper;
import fishclub.ru.fishclubserver.service.bait.BaitControllerService;
import fishclub.ru.fishclubserver.service.bait.BaitService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("baitControllerService")
public class BaitControllerServiceImpl implements BaitControllerService {

    @Resource(name = "baitService")
    private BaitService baitService;

    @Resource
    private BaitMapper baitMapper;

    @Override
    public BaitResponseDto createNewBait(BaitRequestDto request) {
        Bait newBait = baitMapper.mapToEntity(request);
        newBait = baitService.createBait(newBait);
        return baitMapper.mapToDto(newBait);
    }

    @Override
    public BaitResponseDto getBaitById(String baitId) {
        BaitResponseDto result = null;
        if (StringUtils.isNotEmpty(baitId)) {
            Bait resultBait = baitService.getBaitById(Long.parseLong(baitId));
            result = baitMapper.mapToDto(resultBait);
        }
        return result;
    }

    @Override
    public BaitResponseDto updateById(String baitId, BaitRequestDto request) {
        if (StringUtils.isNotEmpty(baitId)) {
            Bait updBait = baitService.getBaitById(Long.parseLong(baitId));
            Bait curBait = baitMapper.mapToEntity(request);
            baitService.updateBait(curBait, updBait);
            return baitMapper.mapToDto(updBait);
        }
        return null;
    }

    @Override
    public void deleteBaitById(String baitId) {
        if (StringUtils.isNotBlank(baitId)) {
            baitService.deleteBaitById(Long.parseLong(baitId));
        }
    }
}
