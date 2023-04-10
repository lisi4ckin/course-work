package fishclub.ru.fishclubserver.dto.fish;

import com.fasterxml.jackson.annotation.JsonInclude;
import fishclub.ru.fishclubserver.dto.lake.LakeReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Информация о рыбе")
public class FishResponseDto {

    @Schema(description = "Идентификатор рыбы")
    private String id;
    @Schema(description = "Наименование рыбы")
    private String fishName;
    @Schema(description = "Средний вес рыбы (в кг)")
    private Float avgWeight;
    @Schema(description = "Дата начала запрета ловли (месяц)")
    private String startDateOfProhibition;
    @Schema(description = "Дата окнчания запрета ловли (месяц)")
    private String endDateOfProhibition;
    @Schema(description = "Нахождение в озерах")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<LakeReferenceDto> lakes;

}
