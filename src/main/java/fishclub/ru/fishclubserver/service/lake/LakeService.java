package fishclub.ru.fishclubserver.service.lake;

import fishclub.ru.fishclubserver.entity.Lake;
import fishclub.ru.fishclubserver.mapper.lake.LakeMapper;
import fishclub.ru.fishclubserver.repository.lake.LakeRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("lakeService")
public class LakeService {

    @Resource
    private LakeRepository lakeRepository;

    @Resource
    private LakeMapper lakeMapper;

    public Lake createNewLake(Lake request) {
        lakeRepository.save(request);
        return request;
    }

    public List<Lake> getLakesByIds(List<Long> ids) {
        return lakeRepository.getEntityList(ids);
    }

    public Lake getLakeById(Long lakeId) {
        Lake result = lakeRepository.getEntity(lakeId);
        if (Objects.isNull(result)) {
            return null;
        }
        return result;
    }

    public Lake updateLake(Lake updLake, Lake curLake) {
        lakeMapper.updateLake(curLake, updLake);
        lakeRepository.save(updLake);
        return updLake;
    }

    public void deleteLake(Long id) {
        if (lakeRepository.existsById(id)) {
            lakeRepository.deleteById(id);
        }
    }
}
