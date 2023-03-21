package fishclub.ru.fishclubserver.dto.fish;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Информация для создания/обновления данных о рыбе")
public class FishRequestDto {
}
