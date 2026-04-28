package by.tests.gpsolutionstest.dto;

import lombok.Data;

@Data
public class AddressGetDto {

    private Integer houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;
}
