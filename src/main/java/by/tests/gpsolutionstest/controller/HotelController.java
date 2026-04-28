package by.tests.gpsolutionstest.controller;

import by.tests.gpsolutionstest.Parameters;
import by.tests.gpsolutionstest.dto.*;
import by.tests.gpsolutionstest.facade.HotelFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/property-view")
@RequiredArgsConstructor
public class HotelController {

    private final HotelFacade hotelFacade;

    @GetMapping("/hotels")
    public List<HotelGetShortInformationDto> getAll() {
        return hotelFacade.getAll();
    }

    @GetMapping("/hotels/{id}")
    public HotelGetFullInformationDto getById(@PathVariable Long id) {
        return hotelFacade.getById(id);
    }

    @GetMapping("/search")
    public List<HotelGetShortInformationDto> getByParameters(@ModelAttribute HotelSearchFilterDto parameters) {
        return hotelFacade.findByParameters(parameters);
    }

    @PostMapping("/hotels")
    public HotelGetShortInformationDto create(@RequestBody HotelCreateDto hotelDto) {
        return hotelFacade.create(hotelDto);
    }

    @PostMapping("/hotels/{id}/amenities")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addAmenities(@PathVariable Long id, @RequestBody ArrayList<AmenityAddDto> amenities) {
        hotelFacade.addAmenities(id, amenities);
    }

    @GetMapping("/histogram/{param}")
    public HashMap<String, Long> getHistogram(@PathVariable Parameters param) {
        return hotelFacade.getHistogram(param);
    }
}
