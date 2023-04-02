package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.fishermen.FishermenMapper;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class FishermenService {

    @Resource
    private FishermenMapper fishermenMapper;

    @Resource
    private FishermenRepository fishermenRepository;

    public Fishermen getFishermenById(Long id) {
        Fishermen fishermen = fishermenRepository.getEntity(id);
        if (Objects.isNull(fishermen)) {
            return null;
        }
        return fishermen;
    }

    public Fishermen createFishermen(Fishermen request) {
        fishermenRepository.save(request);
        return request;
    }

    public Fishermen updateFishermen(Fishermen updFishermen, Fishermen curFishermen) {
        fishermenMapper.updateFishermen(curFishermen, updFishermen);
        fishermenRepository.save(updFishermen);
        return updFishermen;
    }

    public void deleteFishermen(Long id) {
        fishermenRepository.deleteById(id);
    }
}
