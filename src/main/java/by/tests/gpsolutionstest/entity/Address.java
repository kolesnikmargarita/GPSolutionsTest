package by.tests.gpsolutionstest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "address")
@Table(name = "address")
@Data
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_number", nullable = false)
    private Integer houseNumber;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "post_code", nullable = false)
    private String postCode;

    @OneToOne(optional = false, mappedBy = "address")
    private Hotel hotel;
}
