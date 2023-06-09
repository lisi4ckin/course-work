package fishclub.ru.fishclubserver.repository.fish.impl;

import fishclub.ru.fishclubserver.data.fishermen.dao.FishermenJournalDao;
import fishclub.ru.fishclubserver.data.fishes.dao.FishjournalDao;
import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.repository.fish.FishJournalRepository;
import jakarta.annotation.Resource;

import java.util.List;

public class FishJournalRepositoryImpl implements FishJournalRepository {

    @Resource
    private FishjournalDao fishjournalDao;

    @Override
    public List<FishJournalEntity> getJournalList() {
        return fishjournalDao.get();
    }
}
