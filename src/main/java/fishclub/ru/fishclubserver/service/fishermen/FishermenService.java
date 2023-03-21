package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FishermenService {

    @Resource
    private FishermenRepository fishermenRepository;

    public Fishermen createFishermen(Fishermen request) {
        fishermenRepository.save(request);
        return request;
    }
}
