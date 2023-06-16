package fishclub.ru.fishclubserver.dto.bait;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Информация о наживке")
public class BaitJournalDto {

    @Schema(description = "Идентификатор наживки")
    private String baitId;
    @Schema(description = "Наименование наживки")
    private String baitName;
    @Schema(description = "Тип наживки")
    private String baitType;
    @Schema(description = "Техника ловли на наживку")
    private String baitTechnic;
}
