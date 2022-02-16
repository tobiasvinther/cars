package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //man kunne også bruge AUTO
    private int id;

    @CreationTimestamp
    private LocalDate reservationDate;
    private LocalDate rentalDate;

    @UpdateTimestamp
    private LocalDateTime lastEdited;

    @ManyToOne //the car that is reserved
    private Car reservedCar;
    @ManyToOne
    private Member reservingMember;

    public Reservation() {
    }

    public Reservation(LocalDate rentalDate, Car reservedCar, Member reservingMember) {
        this.rentalDate = rentalDate;
        this.reservedCar = reservedCar;
        this.reservingMember = reservingMember;
        reservedCar.addReservation(this); //add reservation to Car's list of reservations
        reservingMember.addReservation(this); //add reservation to Member's list of reservations
    }

    public int getId() {
        return id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }
}
