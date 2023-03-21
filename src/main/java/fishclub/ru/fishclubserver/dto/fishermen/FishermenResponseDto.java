package fishclub.ru.fishclubserver.dto.fishermen;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

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
}
