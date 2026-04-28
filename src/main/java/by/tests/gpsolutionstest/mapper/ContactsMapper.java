package by.tests.gpsolutionstest.mapper;

import by.tests.gpsolutionstest.dto.ContactGetDto;
import by.tests.gpsolutionstest.entity.Contact;

public class ContactsMapper {

    public static ContactGetDto toDto(Contact entity) {
        ContactGetDto dto = new ContactGetDto();

        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());

        return dto;
    }

    public static Contact toEntity(ContactGetDto dto) {
        Contact entity = new Contact();

        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());

        return entity;
    }
}
