package com.edu.cs554.airlinesreservationsystem.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.PRIVATE)
    private int id;
    @Column(name="reservationCode", length = 6)
    private String reservationCode;
    @ManyToOne
    private Passenger passenger;
    @ManyToMany(mappedBy = "reservations")
    private List<Flight> flights=new ArrayList<>();
    private LocalDate reservationTime;
    @ManyToOne
    private User reservedBy;
    @OneToMany(mappedBy = "reservation")
    private List<Ticket> tickets=new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Status status;

    public Reservation(String reservationCode, Passenger passenger, LocalDate reservationTime, User reservedBy, Status status) {
        this.reservationCode = reservationCode;
        this.passenger = passenger;
        this.reservationTime = reservationTime;
        this.reservedBy = reservedBy;
        this.status = status;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }
}
