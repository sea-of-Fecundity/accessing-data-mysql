package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.domain.HelloMember;
import com.example.accessingdatamysql.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }


    @Test
    void test1() throws Exception {

        //expect
        this.mockMvc.perform(MockMvcRequestBuilders.post("/demo/add")
                        .param("name", "myName")
                        .param("email", "hello@Email.com"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().string("Saved"))
                .andExpect(status().isOk());
    }


    @Test
    void test2() throws Exception {
        //given
        IntStream.range(0, 30).forEach((i) -> userRepository.save(new HelloMember("name" + i, "email" + i)));

        //expect
        this.mockMvc.perform(MockMvcRequestBuilders.get("/demo/all"))
                .andDo(MockMvcResultHandlers.print())

                .andExpect(status().isOk());

    }
}