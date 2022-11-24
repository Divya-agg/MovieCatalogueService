package com.javabrains.moviecatalogservice.resources;

import com.javabrains.moviecatalogservice.models.UserRating;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {MovieCatalogResource.class})
@ExtendWith(SpringExtension.class)
class MovieCatalogResourceTest {

    @MockBean
    private WebClient.Builder builder;

    @Autowired
    private MovieCatalogResource movieCatalogResource;

    @MockBean
    private RestTemplate restTemplate;

    int var;
    @Before
    void setUp() {

    }

    @Test
    void getCatalog() {
    }

    /**
     * Method under test: {@link MovieCatalogResource#getCatalog(String)}
     */
    @Test
    void testGetCatalog() throws Exception {
        UserRating userRating = new UserRating();
        userRating.setUserRating(new ArrayList<>());

        when(this.restTemplate.getForObject((String) any(), (Class<UserRating>) any(), (Object[]) any()))
                .thenReturn(userRating);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/catalog/{userId}", "42");
        MockMvcBuilders.standaloneSetup(this.movieCatalogResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}