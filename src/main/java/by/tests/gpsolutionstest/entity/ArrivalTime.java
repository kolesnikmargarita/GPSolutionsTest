package by.tests.gpsolutionstest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity(name = "arrival_times")
@Table(name = "arrival_times")
@Data
public class ArrivalTime {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    private LocalTime checkIn;

    @Column(name = "check_out")
    private LocalTime checkOut;

    @OneToOne(optional = false, mappedBy = "arrivalTime")
    private Hotel hotel;
}
