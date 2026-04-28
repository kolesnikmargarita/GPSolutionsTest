package by.tests.gpsolutionstest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "amenities")
@Table(name = "amenities")
@Data
public class Amenity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "amenities")
    private Collection<Hotel> hotels;
}
