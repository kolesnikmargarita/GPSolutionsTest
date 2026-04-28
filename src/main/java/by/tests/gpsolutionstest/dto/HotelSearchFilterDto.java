package by.tests.gpsolutionstest.dto;

import lombok.Data;

import java.util.List;

@Data
public class HotelSearchFilterDto {
    private String name;
    private String brand;
    private String city;
    private String country;
    private List<String> amenities;
}
