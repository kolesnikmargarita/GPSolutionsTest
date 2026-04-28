package by.tests.gpsolutionstest.mapper;

import by.tests.gpsolutionstest.dto.AddressGetDto;
import by.tests.gpsolutionstest.entity.Address;

public class AddressMapper {

    public static AddressGetDto toDto(Address entity) {
        AddressGetDto dto = new AddressGetDto();

        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setStreet(entity.getStreet());
        dto.setPostCode(entity.getPostCode());
        dto.setHouseNumber(entity.getHouseNumber());

        return dto;
    }

    public static Address toEntity(AddressGetDto dto) {
        Address entity = new Address();

        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setStreet(dto.getStreet());
        entity.setPostCode(dto.getPostCode());
        entity.setHouseNumber(dto.getHouseNumber());

        return entity;
    }
}
