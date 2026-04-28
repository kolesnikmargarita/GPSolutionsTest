package by.tests.gpsolutionstest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "contacts")
@Table(name = "contacts")
@Data
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(optional = false, mappedBy = "contact")
    private Hotel hotel;
}
