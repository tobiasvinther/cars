package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //lav evt om til beforeAll
    @BeforeEach
    void setUp() {
        memberRepository.save(new Member("KW","kw@a.dk","test12","Kurt","Wonnegut","Lyngbyvje 34","Lyngby","2800"));
        memberRepository.save(new Member("HW","hw@a.dk","test12","Hanne","Wonnegut","Lyngbyvje 34","Lyngby","2800"));
    }
    @Test
    public void testCount() {
        assertEquals(2, memberRepository.count());
    }
}