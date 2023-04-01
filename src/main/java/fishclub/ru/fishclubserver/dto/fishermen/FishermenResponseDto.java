package fishclub.ru.fishclubserver.dto.fishermen;

import com.fasterxml.jackson.annotation.JsonInclude;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Schema(description = "Информация по рыболову")
public class FishermenResponseDto {

    @Schema(description = "Идентификатор")
    private String id;

    @Schema(description = "Полное имя рыболова")
    private String fullName;

    @Schema(description = "Возраст рыболова")
    private Integer age;

    @Schema(description = "Опыт рыболова")
    private Integer experience;

    @Schema(description = "Список предпочитаемых рыб")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FishReferenceDto> preferencesFishes;
}
