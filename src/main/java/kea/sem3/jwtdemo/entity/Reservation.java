package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public Reservation() {
    }

    public Reservation(LocalDateTime reservationDate, LocalDateTime rentalDate) {
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
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
