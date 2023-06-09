package fishclub.ru.fishclubserver.dto.fish;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Информация о рыбе")
public class FishJournalDto {

    @Schema(description = "Идентификатор рыбы")
    private String fishId;
    @Schema(description = "Наименование рыбы")
    private String fishName;
    @Schema(description = "Средний вес рыбы (в кг)")
    private Float avgWeight;
    @Schema(description = "Дата начала запрета ловли (месяц)")
    private String startDateOfProhibition;
    @Schema(description = "Дата окнчания запрета ловли (месяц)")
    private String endDateOfProhibition;
}
