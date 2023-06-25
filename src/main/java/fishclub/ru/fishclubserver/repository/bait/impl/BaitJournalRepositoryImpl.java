package fishclub.ru.fishclubserver.repository.bait.impl;

import fishclub.ru.fishclubserver.data.baits.dao.BaitJournalDao;
import fishclub.ru.fishclubserver.data.baits.entity.BaitJournalEntity;
import fishclub.ru.fishclubserver.repository.bait.BaitJournalRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaitJournalRepositoryImpl implements BaitJournalRepository {

    @Resource
    private BaitJournalDao baitjournalDao;

    @Override
    public List<BaitJournalEntity> getJournalList() {
        return baitjournalDao.get();
    }
}
