package fishclub.ru.fishclubserver.data.fishermen.dao.impl;

import fishclub.ru.fishclubserver.data.base.BaseDao;
import fishclub.ru.fishclubserver.data.fishermen.dao.FishermenJournalDao;
import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.data.fishermen.mapper.FishermenJournalListExtractor;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fishermenDaoRepository")
public class FishermenJournalDaoImpl extends BaseDao implements FishermenJournalDao {

    @Resource(name = "fishermenJournalListExtractor")
    private FishermenJournalListExtractor fishermenJournalListExtractor;

    protected FishermenJournalDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @SneakyThrows
    @Override
    public List<FishermenJournalEntity> get() {

        List<FishermenJournalEntity> result = null;
        final StringBuilder sql = new StringBuilder();

        sql.append("SELECT fm.FISHERMAN_ID, fm.FULL_NAME, fm.AGE, fm.EXPERIENCE FROM FISHERMEN fm");
        try {
            result = super.getNamedParameterJdbcTemplate().query(sql.toString(), fishermenJournalListExtractor);
        } catch (DataAccessException exception) {
            throw new Exception("Ошибка получения данных журнала", exception);
        }
        return result;
    }
}
