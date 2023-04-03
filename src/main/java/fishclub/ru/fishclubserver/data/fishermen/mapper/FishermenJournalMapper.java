package fishclub.ru.fishclubserver.data.fishermen.mapper;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FishermenJournalMapper implements RowMapper<FishermenJournalEntity> {

    @Override
    public FishermenJournalEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final FishermenJournalEntity result = new FishermenJournalEntity();
        result.setAge(rs.getLong("AGE"));
        result.setExperience(rs.getLong("EXPERIENCE"));
        result.setName(rs.getString("FULL_NAME"));

        return result;
    }
}
