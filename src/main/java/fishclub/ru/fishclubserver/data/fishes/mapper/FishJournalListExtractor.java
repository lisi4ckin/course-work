package fishclub.ru.fishclubserver.data.fishes.mapper;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.data.fishermen.mapper.FishermenJournalMapper;
import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FishJournalListExtractor implements ResultSetExtractor<List<FishJournalEntity>> {

    private final FishJournalMapper fishJournalMapper;

    public FishJournalListExtractor(FishJournalMapper fishJournalMapper) {
        this.fishJournalMapper = fishJournalMapper;
    }

    @Override
    public List<FishJournalEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {
        final ArrayList<FishJournalEntity> result = new ArrayList<>();
        while (rs.next()) {
            result.add(fishJournalMapper.mapRow(rs, 0));
        }
        return result;
    }
}
