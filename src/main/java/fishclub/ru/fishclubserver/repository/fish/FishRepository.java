package fishclub.ru.fishclubserver.repository.fish;

import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.repository.base.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends BaseEntityRepository<Fish> { }
