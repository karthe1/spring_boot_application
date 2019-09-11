package com.karthick;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = TestProfileController.class)
@SpringBootTest
public class TestProfileController {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getHello() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
			new URL("http://localhost:" + "8080" + "/").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());
    }

}
