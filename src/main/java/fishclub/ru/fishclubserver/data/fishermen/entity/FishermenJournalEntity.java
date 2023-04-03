package fishclub.ru.fishclubserver.data.fishermen.entity;

import fishclub.ru.fishclubserver.entity.base.BaseJournalEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FishermenJournalEntity extends BaseJournalEntity<Long> {

    private String name;
    private Long age;
    private Long experience;
}
