package umc.umcspring.converter;

import umc.umcspring.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return new TempResponse.TempTestDTO().builder()
                .testString("This is Test!")
                .build();
    }
}

