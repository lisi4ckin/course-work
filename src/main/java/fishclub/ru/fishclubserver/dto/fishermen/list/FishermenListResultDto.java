package fishclub.ru.fishclubserver.dto.fishermen.list;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Информация для журнала рыболовов")
public class FishermenListResultDto {

    private String fishermenId;
    private String fishermenFullName;
    private Long age;
    private Long experience;
}
