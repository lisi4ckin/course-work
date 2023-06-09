package fishclub.ru.fishclubserver.data.fishes.dao;

import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;

import java.util.List;

public interface FishJournalDao {

    List<FishJournalEntity> get();
}
