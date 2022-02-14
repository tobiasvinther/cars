package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationRepositoryTest {

    @Autowired
    ReservationRepository reservationRepository;
    static int reservationId1;

    /*
    @BeforeEach
    void setUp() {
        Reservation reservation1 = reservationRepository.save(new Reservation(LocalDateTime.now(), LocalDateTime.now()));
        reservationId1 = reservation1.getId();

    }

    @Test
    public void reservationCountTest() {
        assertEquals(1, reservationRepository.count());
    }

     */

    /*
    @Test
    public void testGetById() {
        Reservation reservationFound = reservationRepository.findById(reservationId1).orElse(null);
        assertEquals(1, reservationFound.getId());
    }

     */

}