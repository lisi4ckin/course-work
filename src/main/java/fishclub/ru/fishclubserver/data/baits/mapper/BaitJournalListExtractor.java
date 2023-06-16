package fishclub.ru.fishclubserver.data.baits.mapper;

import fishclub.ru.fishclubserver.data.baits.entity.BaitJournalEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BaitJournalListExtractor implements ResultSetExtractor<List<BaitJournalEntity>> {

    private final BaitJournalMapper baitJournalMapper;

    public BaitJournalListExtractor(BaitJournalMapper baitJournalMapper) {
        this.baitJournalMapper = baitJournalMapper;
    }

    @Override
    public List<BaitJournalEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {
        final ArrayList<BaitJournalEntity> result = new ArrayList<>();
        while (rs.next()) {
            result.add(baitJournalMapper.mapRow(rs, 0));
        }
        return result;
    }
}
