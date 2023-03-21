package fishclub.ru.fishclubserver.repository.base;

import fishclub.ru.fishclubserver.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseEntityRepository <T extends BaseEntity> extends JpaRepository<T, Long> {

    @Query("select t from #{#entityName} t where t.id = ?1")
    T getEntity(Long id);
}
