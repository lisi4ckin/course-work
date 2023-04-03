package fishclub.ru.fishclubserver.repository.fishermen.impl;

import fishclub.ru.fishclubserver.data.fishermen.dao.FishermenJournalDao;
import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenJournalRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FishermenJournalRepositoryImpl implements FishermenJournalRepository {

    @Resource
    private FishermenJournalDao fishermenJournalDao;

    @Override
    public List<FishermenJournalEntity> getJournalList() {
        return fishermenJournalDao.get();
    }
}
