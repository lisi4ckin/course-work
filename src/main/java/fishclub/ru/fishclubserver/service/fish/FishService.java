package fishclub.ru.fishclubserver.service.fish;

import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.mapper.fish.FishMapper;
import fishclub.ru.fishclubserver.repository.fish.FishJournalRepository;
import fishclub.ru.fishclubserver.repository.fish.FishRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("fishService")
public class FishService {

    @Resource
    private FishRepository fishRepository;

    @Resource
    private FishMapper fishMapper;

    @Resource
    private FishJournalRepository fishJournalRepository;

    public List<FishJournalEntity> getJournal() {
        return fishJournalRepository.getJournalList();
    }

    public Fish createNewFish(Fish request) {
        fishRepository.save(request);
        return request;
    }

    public List<Fish> getAllFishes() {
        return fishRepository.findAll();
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

    public Fish updateFish(Fish updFish, Fish curFish) {
        fishMapper.updateFish(curFish, updFish);
        fishRepository.save(updFish);
        return updFish;
    }

    public void deleteFish(Long id) {
        if (fishRepository.existsById(id)) {
            fishRepository.deleteById(id);
        }
    }
}
