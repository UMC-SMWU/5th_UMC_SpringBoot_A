package umc.spring.service.StoreService;

import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.util.Optional;


public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    Optional<Mission> findMission(Long id);
}
