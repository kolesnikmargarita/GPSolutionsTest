package by.tests.gpsolutionstest.specification;

import by.tests.gpsolutionstest.dto.HotelSearchFilterDto;
import by.tests.gpsolutionstest.entity.Amenity;
import by.tests.gpsolutionstest.entity.Hotel;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class HotelSpecificationSearch {

    public static Specification<Hotel> build(HotelSearchFilterDto filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();
            query.distinct(true);

            if (filter.getName() != null && !filter.getName().isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("name")),
                        filter.getName().toLowerCase()
                ));
            }

            if (filter.getBrand() != null && !filter.getBrand().isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("brand")),
                        filter.getBrand().toLowerCase()
                ));
            }

            if (filter.getCity() != null && !filter.getCity().isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("address").get("city")),
                        filter.getCity().toLowerCase()
                ));
            }

            if (filter.getCountry() != null && !filter.getCountry().isBlank()) {
                predicates.add(cb.like(
                        cb.lower(root.get("address").get("country")),
                        filter.getCountry().toLowerCase()
                ));
            }

            if (filter.getAmenity() != null && !filter.getAmenity().isEmpty()) {
                Join<Hotel, Amenity> join = root.join("amenities", JoinType.INNER);
                predicates.add(join.get("name").in(filter.getAmenity()));
                query.distinct(true);
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
