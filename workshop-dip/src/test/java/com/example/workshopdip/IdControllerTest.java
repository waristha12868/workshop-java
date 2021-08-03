package com.example.workshopdip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IdControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("REST API /id")
    public void case01() {
        // Act
        IdResponse response = restTemplate.getForObject("/id", IdResponse.class);
        // Assert
        assertEquals("XYZ7", response.getResult());
    }
}
