package fishclub.ru.fishclubserver.data.fishermen.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FishermenReportHeaders {

    NAME("ФИО", 1),
    AGE("Возраст", 2),
    EXPERIENCE("Опыт", 3),
    PASSPORT_NUMBER("Номер паспорта", 4),
    PASSPORT_SERIES("Серия паспорта", 5),
    PREFERENCES_FISHES("Предпочитаемые рыбы", 6);

    private final String columnName;
    private final Integer columnIndex;
}
