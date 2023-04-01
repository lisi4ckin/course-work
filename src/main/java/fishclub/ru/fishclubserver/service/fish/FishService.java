package fishclub.ru.fishclubserver.service.fish;

import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.repository.fish.FishRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("fishService")
public class FishService {

    @Resource
    private FishRepository fishRepository;

    public Fish createNewFish(Fish request) {
        fishRepository.save(request);
        return request;
    }

    public List<Fish> getFishesByIds(List<Long> ids) {
        return fishRepository.getEntityList(ids);
    }

    public Fish getFishById(Long fishId) {
        Fish result = fishRepository.getEntity(fishId);
        if (Objects.isNull(result)) {
            return null;
        }
        return result;
    }
}
