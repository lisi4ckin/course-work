package fishclub.ru.fishclubserver.dto.bait;

import fishclub.ru.fishclubserver.dto.base.BaseReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Справочник наживок")
public class BaitReferenceDto extends BaseReferenceDto {

}
