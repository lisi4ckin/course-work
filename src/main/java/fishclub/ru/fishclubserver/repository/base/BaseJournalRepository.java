package fishclub.ru.fishclubserver.repository.base;

import fishclub.ru.fishclubserver.entity.base.BaseJournalEntity;

import java.util.List;

public interface BaseJournalRepository<E extends BaseJournalEntity<Long>> {

    List<E> getJournalList();
}
