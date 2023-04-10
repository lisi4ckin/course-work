package fishclub.ru.fishclubserver.dto.lake;

import com.fasterxml.jackson.annotation.JsonInclude;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Полная информация об озере")
public class LakeResponseDto {

    @Schema(description = "Идентификатор озера")
    private String id;

    @Schema(description = "Наименование озера")
    private String lakeName;

    @Schema(description = "Глубина озера")
    private Long depth;

    @Schema(description = "Дата начала сезона ловли")
    private String startSeasonDate;

    @Schema(description = "Дата окончания сезона ловли")
    private String endSeasonDate;

    @Schema(description = "Рыбы, которые водятся в озере")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FishReferenceDto> fishInLakes;
}
