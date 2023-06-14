package fishclub.ru.fishclubserver.data.fishermen.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FishermenReportHeaders {

    NAME("ФИО", 1),
    AGE("Возраст", 2),
    EXPERIENCE("Опыт", 3),
    PREFERENCES_FISHES("Предпочитаемые рыбы", 4);

    private final String columnName;
    private final Integer columnIndex;
}
