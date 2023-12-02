package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id){
        return storeRepository.findById(id);
    }

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }
}
