package fishclub.ru.fishclubserver.dto.bait;

import com.fasterxml.jackson.annotation.JsonInclude;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Информация по наживке")
public class BaitResponseDto {

    @Schema(description = "Идентификатор наживки")
    private String id;

    @Schema(description = "Наименование наживки")
    private String baitName;

    @Schema(description = "Тип наживки")
    private String baitType;

    @Schema(description = "Техника ловли на наживку")
    private String baitTechnic;

    @Schema(description = "Рыбы, которые клуют на наживку")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FishReferenceDto> fishes;
}
