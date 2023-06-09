package fishclub.ru.fishclubserver.data.fishes.dao.impl;

import fishclub.ru.fishclubserver.data.base.BaseDao;
import fishclub.ru.fishclubserver.data.fishes.dao.FishJournalDao;
import fishclub.ru.fishclubserver.data.fishes.entity.FishJournalEntity;
import fishclub.ru.fishclubserver.data.fishes.mapper.FishJournalListExtractor;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class FishJournalDaoImpl extends BaseDao implements FishJournalDao {
    @Resource
    private FishJournalListExtractor fishJournalListExtractor;

    protected FishJournalDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @SneakyThrows
    @Override
    public List<FishJournalEntity> get() {

        List<FishJournalEntity> result = null;
        final StringBuilder sql = new StringBuilder();

        sql.append("SELECT fm.FISH_ID, fm.NAME, fm.AVERAGE_WEIGHT, fm.START_DATE_OF_PROHIBITION, fm.END_DATE_OF_PROHIBITION FROM FISHES fm");
        try {
            result = super.getNamedParameterJdbcTemplate().query(sql.toString(), fishJournalListExtractor);
        } catch (DataAccessException exception) {
            throw new Exception("Ошибка получения данных журнала", exception);
        }
        return result;
    }
}
