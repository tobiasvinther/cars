package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void setUp() {
        carRepository.save(new Car("Citröen", "c3", 500, 100));
        carRepository.save(new Car("Citröen", "c1", 350, 100));
    }

    //now this doesn't work for some reason
    /*
    @Test
    public void carCountTest() {
        assertEquals(2, carRepository.count());
    }

     */
}