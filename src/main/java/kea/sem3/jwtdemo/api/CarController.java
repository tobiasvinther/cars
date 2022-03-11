package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.service.CarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/cars")
public class CarController {
    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> getCars(){
        return carService.getCars();
    }

    //curly brackets viser at det er en variabel der kommer ind og den hænger sammen med @PathVariable
    @GetMapping("/{id}")
    public CarResponse getCar(@PathVariable int id) throws Exception {
        return carService.getCar(id, false);
    }

    //HTTP's request body kommer ind som JSON, men konverteres af Jackson-frameworket da dataen matcher dto-klassens fields
    @RolesAllowed("ADMIN")
    @PostMapping
    public CarResponse addCar(@RequestBody CarRequest body){
        return carService.addCar(body);
    }

    @RolesAllowed("ADMIN")
    @PutMapping("/{id}") //@RequestBody laver JSON om til CarRequest-klasse
    public CarResponse editCar(@RequestBody CarRequest body, @PathVariable int id) throws Exception {
        return carService.editCar(body, id);
    }

    @RolesAllowed("ADMIN")
    @PatchMapping("/{id}/{newPrice}")
    public void editPrice(@PathVariable int id, @PathVariable double newPrice) throws Exception {
        carService.updatePrice(id, newPrice);
    }

    @RolesAllowed("ADMIN")
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) throws Exception {
        carService.deleteCar(id);
    }

}

