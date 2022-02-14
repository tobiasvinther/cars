package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDateTime reservationDate;
    private LocalDateTime rentalDate;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastEdited;

    @ManyToOne //the car that is reserved
    private Car reservedCar;
    @ManyToOne
    private Member reservingMember;

    public Reservation() {
    }

    public Reservation(LocalDateTime reservationDate, LocalDateTime rentalDate, Car reservedCar, Member reservingMember) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
        this.reservedCar = reservedCar;
        this.reservingMember = reservingMember;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastEdited() {
        return lastEdited;
    }
}
