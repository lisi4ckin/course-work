package fishclub.ru.fishclubserver.dto.fish;

import fishclub.ru.fishclubserver.dto.base.BaseReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Информация для создания связей")
public class FishReferenceDto extends BaseReferenceDto {
}
