package fishclub.ru.fishclubserver.data.fishes.mapper;

import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FishJournalMapper implements RowMapper<FishJournalEntity> {

    @Override
    public FishJournalEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final FishJournalEntity result = new FishJournalEntity();
        result.setFishId(String.valueOf(rs.getLong("FISH_ID")));
        result.setFishName(rs.getString("NAME"));
        result.setAverageWeight(rs.getFloat("AVERAGE_WEIGHT"));
        result.setStartDateOfProhibition(rs.getString("START_DATE_OF_PROHIBITION"));
        result.setEndDateOfProhibition(rs.getString("END_DATE_OF_PROHIBITION"));

        return result;
    }
}
