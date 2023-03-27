package fishclub.ru.fishclubserver.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseReferenceDto {

    private String id;
    private String referenceName;
}
