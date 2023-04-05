package fishclub.ru.fishclubserver.service.bait;

import fishclub.ru.fishclubserver.entity.Bait;
import fishclub.ru.fishclubserver.mapper.bait.BaitMapper;
import fishclub.ru.fishclubserver.repository.bait.BaitRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service("baitService")
public class BaitService {

    @Resource
    private BaitRepository baitRepository;

    @Resource
    private BaitMapper baitMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bait createBait(Bait bait) {
        Bait result = baitRepository.save(bait);
        return result;
    }

    public Bait getBaitById(Long id) {
        if (baitRepository.existsById(id)) {
            return baitRepository.getEntity(id);
        }
        return null;
    }

    public List<Bait> getBaitByIds(List<Long> ids) {
        if (ids != null && !ids.isEmpty()) {
            return baitRepository.getEntityList(ids);
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bait updateBait(Bait curBait, Bait updBait) {
        baitMapper.updateBait(curBait, updBait);
        return updBait;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteBaitById(Long id) {
        if (baitRepository.existsById(id)) {
            baitRepository.deleteById(id);
        }
    }
}
