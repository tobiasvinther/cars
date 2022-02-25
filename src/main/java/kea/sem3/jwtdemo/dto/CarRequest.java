package kea.sem3.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    //mapped so it matches JSON, so it can be converted, otherwise it wouldn't work
    private String brand;
    private String model;
    private double pricePrDay;
    private double bestDiscount;
}

