package by.tests.gpsolutionstest.dto;

import lombok.Data;

@Data
public class HotelCreateDto {

    private String name;
    private String description;
    private String brand;
    private AddressGetDto address;
    private ContactGetDto contacts;
    private ArrivalTimeGetDto arrivalTime;
}
