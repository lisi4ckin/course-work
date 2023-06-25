package fishclub.ru.fishclubserver.data.baits.entity;

import fishclub.ru.fishclubserver.entity.base.BaseJournalEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaitJournalEntity extends BaseJournalEntity<Long> {

    private String baitId;
    private String baitName;
    private String baitTechnic;
    private String baitType;
}
