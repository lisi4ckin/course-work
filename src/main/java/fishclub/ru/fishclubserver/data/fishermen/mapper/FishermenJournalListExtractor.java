package fishclub.ru.fishclubserver.data.fishermen.mapper;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FishermenJournalListExtractor implements ResultSetExtractor<List<FishermenJournalEntity>> {

    private final FishermenJournalMapper fishermenJournalMapper;

    public FishermenJournalListExtractor(FishermenJournalMapper fishermenJournalMapper) {
        this.fishermenJournalMapper = fishermenJournalMapper;
    }

    @Override
    public List<FishermenJournalEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {
        final ArrayList<FishermenJournalEntity> result = new ArrayList<>();
        while (rs.next()) {
            result.add(fishermenJournalMapper.mapRow(rs, 0));
        }
        return result;
    }
}
