package fishclub.ru.fishclubserver.dto.fish;

import fishclub.ru.fishclubserver.dto.bait.BaitReferenceDto;
import fishclub.ru.fishclubserver.dto.lake.LakeReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Информация для создания/обновления данных о рыбе")
public class FishRequestDto {

    @Schema(description = "Наименование рыбы")
    private String fishName;

    @Schema(description = "Средний вес рыбы (в кг)")
    private Float avgWeight;

    @Schema(description = "Дата начала запрета на ловлю рыбы (месяц)")
    private String startDateOfProhibition;

    @Schema(description = "Дата окончания запрета на ловлю рыбы (месяц)")
    private String endDateOfProhibition;

    @Schema(description = "Наживки, на которые клюет рыба")
    private List<BaitReferenceDto> baits;

    @Schema(description = "Нахождение в озере")
    private List<LakeReferenceDto> lakes;
}
