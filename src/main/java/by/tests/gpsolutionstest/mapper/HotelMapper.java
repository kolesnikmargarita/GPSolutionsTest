package by.tests.gpsolutionstest.mapper;

import by.tests.gpsolutionstest.dto.HotelCreateDto;
import by.tests.gpsolutionstest.dto.HotelGetFullInformationDto;
import by.tests.gpsolutionstest.dto.HotelGetShortInformationDto;
import by.tests.gpsolutionstest.entity.Address;
import by.tests.gpsolutionstest.entity.Amenity;
import by.tests.gpsolutionstest.entity.Hotel;


public class HotelMapper {

    public static HotelGetShortInformationDto toGetShortInformationDto (Hotel entity) {
        HotelGetShortInformationDto dto = new HotelGetShortInformationDto();

        Address address = entity.getAddress();
        StringBuilder addressString = new StringBuilder();
        addressString.append(address.getHouseNumber())
                        .append(address.getStreet()).append(", ")
                        .append(address.getCity()).append(" ,")
                        .append(address.getPostCode()).append(", ")
                        .append(address.getCountry());

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setAddress(addressString.toString());
        dto.setPhone(entity.getContact().getPhone());

        return dto;
    }

    public static HotelGetFullInformationDto toGetFullInformationDto(Hotel entity) {
        HotelGetFullInformationDto dto = new HotelGetFullInformationDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setBrand(entity.getBrand());
        dto.setContacts(ContactsMapper.toDto(entity.getContact()));
        dto.setAddress(AddressMapper.toDto(entity.getAddress()));
        dto.setArrivalTime(ArrivalTimeMapper.toDto(entity.getArrivalTime()));
        dto.setAmenities(entity.getAmenities().stream().map(Amenity::getName).toList());

        return dto;
    }

    public static Hotel toEntity(HotelCreateDto dto) {
        Hotel entity = new Hotel();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setBrand(dto.getBrand());
        entity.setContact(ContactsMapper.toEntity(dto.getContacts()));
        entity.setAddress(AddressMapper.toEntity(dto.getAddress()));
        entity.setArrivalTime(ArrivalTimeMapper.toEntity(dto.getArrivalTime()));

        return entity;
    }
}
