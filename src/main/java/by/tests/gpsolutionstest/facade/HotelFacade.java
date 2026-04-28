package by.tests.gpsolutionstest.facade;

import by.tests.gpsolutionstest.Parameters;
import by.tests.gpsolutionstest.dto.*;
import by.tests.gpsolutionstest.entity.Amenity;
import by.tests.gpsolutionstest.entity.Hotel;
import by.tests.gpsolutionstest.mapper.AmenitiesMapper;
import by.tests.gpsolutionstest.mapper.HotelMapper;
import by.tests.gpsolutionstest.service.HotelService;
import by.tests.gpsolutionstest.specification.HotelSpecificationSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HotelFacade {

    private final HotelService hotelService;

    @Transactional(readOnly = true)
    public List<HotelGetShortInformationDto> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        return hotels.stream().map(HotelMapper::toGetShortInformationDto).toList();
    }

    @Transactional(readOnly = true)
    public HotelGetFullInformationDto getById(Long id) {
        return HotelMapper.toGetFullInformationDto(hotelService.getById(id));
    }

    @Transactional(readOnly = true)
    public List<HotelGetShortInformationDto> findByParameters(HotelSearchFilterDto parameters) {
        Specification<Hotel> specification = HotelSpecificationSearch.build(parameters);
        List<Hotel> hotels = hotelService.getByParameters(specification);
        return hotels.stream().map(HotelMapper::toGetShortInformationDto).toList();
    }

    @Transactional
    public HotelGetShortInformationDto create(HotelCreateDto hotelDto) {
        Hotel hotel = HotelMapper.toEntity(hotelDto);

        return HotelMapper.toGetShortInformationDto(hotelService.create(hotel));
    }

    @Transactional
    public void addAmenities(Long id, ArrayList<AmenityAddDto> amenities) {
        Hotel hotel = hotelService.getById(id);

        List<Amenity> newAmenities = amenities.stream()
                .map(AmenitiesMapper::toEntity)
                .collect(Collectors.toList());

        Collection<Amenity> existingAmenities = hotel.getAmenities();

        for (Amenity newAmenity : newAmenities) {
            if (!existingAmenities.contains(newAmenity)) {
                existingAmenities.add(newAmenity);
            }
        }

        hotel.setAmenities(existingAmenities);

        hotelService.create(hotel);
    }

    @Transactional(readOnly = true)
    public HashMap<String, Long> getHistogram(Parameters parameter) {
        if(parameter.equals(Parameters.CITY)) {
            return hotelService.getHistogramByCity();
        }
        if(parameter.equals(Parameters.BRAND)) {
            return hotelService.getHistogramByBrand();
        }
        if(parameter.equals(Parameters.COUNTRY)) {
            return hotelService.getHistogramByCountry();
        }
        return hotelService.getHistogramByAmenities();
    }

}
