package fishclub.ru.fishclubserver.data.fishes.dao;

import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;

import java.util.List;

public interface FishjournalDao {

    List<FishJournalEntity> get();
}
