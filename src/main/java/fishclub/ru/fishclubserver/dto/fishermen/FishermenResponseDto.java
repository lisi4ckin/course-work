package fishclub.ru.fishclubserver.dto.fishermen;

import com.fasterxml.jackson.annotation.JsonInclude;
import fishclub.ru.fishclubserver.dto.fish.FishReferenceDto;
import fishclub.ru.fishclubserver.dto.lake.LakeReferenceDto;
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

    @Schema(description = "Серия паспорта")
    private String passportSeries;

    @Schema(description = "Номер паспорта")
    private String passportNumber;

    @Schema(description = "Список предпочитаемых рыб")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<FishReferenceDto> preferencesFishes;

    @Schema(description = "Список озер, на которых рыбачит рыбак")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<LakeReferenceDto> lakes;
}
