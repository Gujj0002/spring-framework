package com.example.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.PostConstruct;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableJpaRepositories
@ComponentScan("com.example.spring")
@ContextConfiguration(classes = bookControllerTest.class)
@WebAppConfiguration
public class bookControllerTest {

    @Autowired
    bookController BookController;

    @Autowired
    bookRepository repository;

    MockMvc mockMvc;

    @PostConstruct
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(BookController).build();
    }
    @Test
    public void checkForController(){
        assertThat(BookController).isNotNull();
    }
    @Test
    public void getAllTest() throws Exception {
        book b = new book();
        b.setName("The Book");
        b = repository.save(b);

        this.mockMvc.perform(get("/api/rest/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$[0].name").value(b.getName()));

        repository.delete(b);
    }

}
