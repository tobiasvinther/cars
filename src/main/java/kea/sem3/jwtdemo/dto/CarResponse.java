package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
    int id;
    //@Enumerated(EnumType.STRING)
    //Change CarBrand into a String if you are not using an enum for this field
    String brand;
    String model;
    double pricePrDay;
    Double bestDiscount; //double so it can hold a null value
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime created;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime updated;

    public CarResponse(Car car, boolean includeAll) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.pricePrDay = car.getPricePrDay();
        this.id = car.getId();

        if(includeAll){
            this.created = car.getCreated();
            this.updated = car.getLastEdited();
            this.bestDiscount = car.getBestDiscount();
        }
    }

    //this could also have been put in the service layer
    public static List<CarResponse> getCarsFromEntities(List<Car> cars){
        return cars.stream().map(car-> new CarResponse(car, false)).collect(Collectors.toList());
    }
}

