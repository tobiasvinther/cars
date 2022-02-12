package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//service-laget konverterer mellem entity og dto

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    //this class is responsible for converting the Car list (entities) to a CarResponse list (DTOs)
    //remember that we don't want users to see the complete entity, therefore we create DTOs
    public List<CarResponse> getCars(){
        //find all the cars in the database
        List<Car> cars = carRepository.findAll();
        //convert cars to CarResponses and return them
        return CarResponse.getCarsFromEntities(cars);
    }

    //returning a CarResponse
    public CarResponse getCar(int id,boolean all) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Client4xxException("No car with this id exists"));
        return new CarResponse(car, all);
    }

    public CarResponse addCar(CarRequest body){
        Car carNew = carRepository.save(new Car(body));
        return new CarResponse(carNew, true);
    }

    public CarResponse editCar(CarRequest body,int id) throws Exception {
        //1. create car from carRequest body (such a constructor exists)
        //2. save that car (should overwrite if it has the same id as existing id)
        //3. convert to carResponse and return
        Car editedCar = new Car(body);
        editedCar.setId(id);
        carRepository.save(editedCar);
        System.out.println("Car edited");

        return getCar(id, true);

        /*
        CarResponse editedCar = getCar(id,true);
        editedCar.setBrand(body.getBrand());
        editedCar.setModel(body.getModel());
        editedCar.setPricePrDay(body.getPricePrDay());
        editedCar.setBestDiscount(body.getBestDiscount());
        carRepository.save(editedCar);

        return editedCar;
         */
    }

    public void deleteCar(int id) throws Exception {
        Car carToDelete = carRepository.findById(id).orElseThrow(() -> new Exception("No car with this id exists"));
        carRepository.delete(carToDelete);
        System.out.println("Car deleted");
    }
}

