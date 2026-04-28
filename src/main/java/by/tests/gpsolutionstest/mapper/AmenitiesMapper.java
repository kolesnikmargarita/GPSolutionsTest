package by.tests.gpsolutionstest.mapper;

import by.tests.gpsolutionstest.dto.AmenityAddDto;
import by.tests.gpsolutionstest.entity.Amenity;

import java.util.List;

public class AmenitiesMapper {

    public static Amenity toEntity(AmenityAddDto dto) {
        Amenity entity = new Amenity();

        entity.setName(dto.getName());

        return entity;
    }

    public static Amenity toEntity(String dto) {
        Amenity entity = new Amenity();

        entity.setName(dto);

        return entity;
    }
}
