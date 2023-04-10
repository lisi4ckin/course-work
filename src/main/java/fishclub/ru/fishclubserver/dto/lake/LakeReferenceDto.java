package fishclub.ru.fishclubserver.dto.lake;

import fishclub.ru.fishclubserver.dto.base.BaseReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Справочная информация по озеру")
public class LakeReferenceDto extends BaseReferenceDto {
}
