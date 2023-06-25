package fishclub.ru.fishclubserver.data.baits.dao.impl;

import fishclub.ru.fishclubserver.data.baits.dao.BaitJournalDao;
import fishclub.ru.fishclubserver.data.baits.entity.BaitJournalEntity;
import fishclub.ru.fishclubserver.data.baits.mapper.BaitJournalListExtractor;
import fishclub.ru.fishclubserver.data.base.BaseDao;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BaitJournalDaoImpl extends BaseDao implements BaitJournalDao {
    @Resource
    private BaitJournalListExtractor baitJournalListExtractor;

    protected BaitJournalDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @SneakyThrows
    @Override
    public List<BaitJournalEntity> get() {

        List<BaitJournalEntity> result = null;
        final StringBuilder sql = new StringBuilder();

        sql.append("SELECT fm.BAIT_ID, fm.NAME, fm.TECHNIC, fm.TYPE FROM BAITS fm");
        try {
            result = super.getNamedParameterJdbcTemplate().query(sql.toString(), baitJournalListExtractor);
        } catch (DataAccessException exception) {
            throw new Exception("Ошибка получения данных журнала", exception);
        }
        return result;
    }
}
