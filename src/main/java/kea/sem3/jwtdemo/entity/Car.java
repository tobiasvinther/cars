package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brand;
    private String model;
    private int pricePrDay;
    private double bestDiscount;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime lastEdited;
    //if problems related to transactional, then use EAGER
    //@OneToMany(mappedBy = "reservedCar", fetch = FetchType.EAGER) //the reservations this car is in
    @OneToMany(mappedBy = "reservedCar") //the reservations this car is in
    private Set<Reservation> reservations = new HashSet<>();

    public Car() {
    }

    public Car(String brand, String model, int pricePrDay, double discount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = pricePrDay;
        this.bestDiscount = discount;
    }

    public Car(CarRequest body) {
        this.brand = body.getBrand();
        this.model = body.getModel();
        this.pricePrDay = (int) body.getPricePrDay();
        this.bestDiscount = body.getBestDiscount();
    }

    public void addReservation(Reservation reservation){
        /*
        //my solution
        for(Reservation existingRes : reservations) {
            if(reservation.getRentalDate().equals(existingRes.getRentalDate())) {
                throw new Exception("Car already booked");
            }
        }
        */

        reservations.add(reservation);
    }

}
