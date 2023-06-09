package fishclub.ru.fishclubserver.repository.fish.impl;

import fishclub.ru.fishclubserver.data.fishes.dao.FishJournalDao;
import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.repository.fish.FishJournalRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishJournalRepositoryImpl implements FishJournalRepository {

    @Resource
    private FishJournalDao fishjournalDao;

    @Override
    public List<FishJournalEntity> getJournalList() {
        return fishjournalDao.get();
    }
}
