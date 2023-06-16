package fishclub.ru.fishclubserver.data.baits.mapper;

import fishclub.ru.fishclubserver.data.baits.entity.BaitJournalEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BaitJournalMapper implements RowMapper<BaitJournalEntity> {

    @Override
    public BaitJournalEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final BaitJournalEntity result = new BaitJournalEntity();
        result.setBaitId(String.valueOf(rs.getLong("BAIT_ID")));
        result.setBaitName(rs.getString("NAME"));
        result.setBaitType(rs.getString("TYPE"));
        result.setBaitTechnic(rs.getString("TECHNIC"));

        return result;
    }
}
