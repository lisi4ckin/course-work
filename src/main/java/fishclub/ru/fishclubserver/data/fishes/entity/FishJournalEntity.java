package fishclub.ru.fishclubserver.data.fishes.entity;

import fishclub.ru.fishclubserver.entity.base.BaseJournalEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FishJournalEntity extends BaseJournalEntity<Long> {

    private String fishId;
    private String fishName;
    private Float averageWeight;
    private String startDateOfProhibition;
    private String endDateOfProhibition;
}
