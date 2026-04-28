package by.tests.gpsolutionstest.service;

import by.tests.gpsolutionstest.entity.Hotel;
import by.tests.gpsolutionstest.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);

        if(hotel.isEmpty()) {
            throw new EntityNotFoundException("Hotel with id = '" + id +  "' not found!");
        }

        return hotel.get();
    }

    public List<Hotel> getByParameters(Specification<Hotel> specification) {
        return hotelRepository.findAll(specification);
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public HashMap<String, Long> getHistogramByCity() {
        List<Object[]> objectHistogram = hotelRepository.getCountByCity();

        HashMap<String, Long> cityHotelCount = new HashMap<>();
        for (Object[] objects : objectHistogram) {
            String city = (String) objects[0];
            Long count = (Long) objects[1];
            cityHotelCount.put(city, count);
        }
        return cityHotelCount;
    }

    public HashMap<String, Long> getHistogramByBrand() {
        List<Object[]> objectHistogram = hotelRepository.getCountByBrand();

        HashMap<String, Long> brandHotelCount = new HashMap<>();
        for (Object[] objects : objectHistogram) {
            String brand = (String) objects[0];
            Long count = (Long) objects[1];
            brandHotelCount.put(brand, count);
        }
        return brandHotelCount;
    }

    public HashMap<String, Long> getHistogramByCountry() {
        List<Object[]> objectHistogram = hotelRepository.getCountByCountry();

        HashMap<String, Long> countryHotelCount = new HashMap<>();
        for (Object[] objects : objectHistogram) {
            String country = (String) objects[0];
            Long count = (Long) objects[1];
            countryHotelCount.put(country, count);
        }
        return countryHotelCount;
    }

    public HashMap<String, Long> getHistogramByAmenities() {
        List<Object[]> objectHistogram = hotelRepository.getCountByAmenities();

        HashMap<String, Long> amenitiesHotelCount = new HashMap<>();
        for (Object[] objects : objectHistogram) {
            String amenities = (String) objects[0];
            Long count = (Long) objects[1];
            amenitiesHotelCount.put(amenities, count);
        }
        return amenitiesHotelCount;
    }
}
