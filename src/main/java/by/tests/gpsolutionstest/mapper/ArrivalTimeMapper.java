package by.tests.gpsolutionstest.mapper;

import by.tests.gpsolutionstest.dto.ArrivalTimeGetDto;
import by.tests.gpsolutionstest.entity.ArrivalTime;

public class ArrivalTimeMapper {

    public static ArrivalTimeGetDto toDto(ArrivalTime entity) {
        ArrivalTimeGetDto dto = new ArrivalTimeGetDto();

        dto.setCheckIn(entity.getCheckIn());
        dto.setCheckOut(entity.getCheckOut());

        return dto;
    }

    public static ArrivalTime toEntity(ArrivalTimeGetDto dto) {
        ArrivalTime entity = new ArrivalTime();

        entity.setCheckIn(dto.getCheckIn());
        entity.setCheckOut(dto.getCheckOut());

        return entity;
    }
}
