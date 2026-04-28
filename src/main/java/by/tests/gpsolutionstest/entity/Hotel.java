package by.tests.gpsolutionstest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "hotels")
@Table(name = "hotels")
@Data
public class Hotel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "brand", nullable = false)
    private String brand;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_time_id")
    private ArrivalTime arrivalTime;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "hotels_amenities",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private Collection<Amenity> amenities;
}
