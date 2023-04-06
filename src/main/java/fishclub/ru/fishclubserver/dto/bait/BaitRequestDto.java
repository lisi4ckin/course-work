package fishclub.ru.fishclubserver.dto.bait;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Информация для создания/обновления наживки")
public class BaitRequestDto {

    @Schema(description = "Наименование наживки")
    private String baitName;

    @Schema(description = "Тип наживки")
    private String baitType;

    @Schema(description = "Техника ловли на наживку")
    private String baitTechnic;

}
