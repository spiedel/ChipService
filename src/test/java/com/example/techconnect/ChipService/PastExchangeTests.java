package com.example.techconnect.ChipService;


import com.example.techconnect.ChipService.models.PastExchange;
import com.example.techconnect.ChipService.repositories.PastExchangeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {ChipServiceApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@TestPropertySource(locations = "classpath:application-testing.properties")
public class PastExchangeTests  {

    @Autowired
    PastExchangeRepository pastExchangeRepository;

    @Autowired
    TestRestTemplate testRestTemplate;




    @Test
    public void canGetAllPastExchanges() {
        ResponseEntity<PastExchange[]> response = testRestTemplate.getForEntity("/pastexchanges", PastExchange[].class);
        PastExchange[] pastExchanges = response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(pastExchanges);
    }


    @Test
    public void canGetOnePastExchange() {
        ResponseEntity<PastExchange> response = testRestTemplate.getForEntity("/pastexchanges/1", PastExchange.class);
        PastExchange pastExchange = response.getBody();
        assertEquals(5.0, pastExchange.getRate(), 0.0);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void cantGetPastExchangeThatDoesNotExist(){
        ResponseEntity<PastExchange> response = testRestTemplate.getForEntity("/pastexchanges/1000", PastExchange.class);
        PastExchange pastExchange = response.getBody();
        assertEquals(null, pastExchange);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void canDeleteOnePastExchange(){
        testRestTemplate.delete("/pastexchanges/2");
        assertFalse(pastExchangeRepository.existsById(2L));
    }

    @Test
    public void cantDeletePastExchangeIfItDoesNotExist(){
        testRestTemplate.delete("/pastexchanges/100000");
    }


}
