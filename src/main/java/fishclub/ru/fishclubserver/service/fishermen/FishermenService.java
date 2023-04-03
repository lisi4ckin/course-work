package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.mapper.fishermen.FishermenMapper;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenJournalRepository;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FishermenService {

    @Resource
    private FishermenMapper fishermenMapper;

    @Resource
    private FishermenRepository fishermenRepository;

    @Resource
    private FishermenJournalRepository fishermenJournalRepository;

    public List<FishermenJournalEntity> getFishermenJournalList() {
        List<FishermenJournalEntity> result = fishermenJournalRepository.getJournalList();
        return result;
    }

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
