package umc.spring.converter;

import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.RegionHandler;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.RegionRepository;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.StoreAddResultDTO toStoreAddResultDTO(Store store){
        return StoreResponseDTO.StoreAddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.StoreAddDto request, RegionRepository regionRepository){

        Region region = regionRepository.findById(request.getRegion())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));


        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }
}
