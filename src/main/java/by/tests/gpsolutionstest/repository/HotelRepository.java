package by.tests.gpsolutionstest.repository;

import by.tests.gpsolutionstest.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {

    @Query("SELECT h.address.city, COUNT(h) FROM hotels h GROUP BY h.address.city")
    List<Object[]> getCountByCity();

    @Query("SELECT h.brand, COUNT(h) FROM hotels h GROUP BY h.brand")
    List<Object[]> getCountByBrand();

    @Query("SELECT h.address.country, COUNT(h) FROM hotels h GROUP BY h.address.country")
    List<Object[]> getCountByCountry();

    @Query(" SELECT a.name, COUNT(h) FROM hotels h JOIN h.amenities a GROUP BY a.name")
    List<Object[]> getCountByAmenities();
}
