package kea.sem3.jwtdemo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import kea.sem3.jwtdemo.entity.Member;
import kea.sem3.jwtdemo.repositories.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //full application context
@AutoConfigureMockMvc
@ActiveProfiles("test") //so that MakeTestData doesn't create data when we run these tests
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private ObjectMapper objectMapper;
    static String member1Id, member2Id;

    @BeforeEach
    void setUp() {
        member1Id = memberRepository.save(new Member("KW","kw@a.dk","test12","Kurt","Wonnegut","Lyngbyvje 34","Lyngby","2800")).getUsername();
        member2Id = memberRepository.save(new Member("HW","hw@a.dk","test12","Hanne","Wonnegut","Lyngbyvje 34","Lyngby","2800")).getUsername();
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    void getAllMembers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/members")
                        .accept(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Hanne")))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Kurt")));
    }

    @Test
    void getMembersFromUserName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/members/" + member1Id)
                        .accept(MediaType.APPLICATION_JSON))
                //.andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(member1Id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("Lyngby"));
    }

    @Test
    void deleteMember() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/members/" + member1Id))
                .andExpect(status().isOk());
        //Verify that we only have one member in the database
        assertEquals(1, memberRepository.count());
    }
}