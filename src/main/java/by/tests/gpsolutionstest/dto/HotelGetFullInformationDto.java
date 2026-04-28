package by.tests.gpsolutionstest.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelGetFullInformationDto {

    private Long id;
    private String name;
    private String description;
    private String brand;
    private AddressGetDto address;
    private ContactGetDto contacts;
    private ArrivalTimeGetDto arrivalTime;
    private List<String> amenities;

}
