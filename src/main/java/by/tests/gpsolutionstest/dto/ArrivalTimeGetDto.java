package by.tests.gpsolutionstest.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ArrivalTimeGetDto {

    private LocalTime checkIn;
    private LocalTime checkOut;

}
