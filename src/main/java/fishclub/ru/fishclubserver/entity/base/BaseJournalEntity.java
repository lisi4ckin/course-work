package fishclub.ru.fishclubserver.entity.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseJournalEntity<ID> {

    private ID id;
}
