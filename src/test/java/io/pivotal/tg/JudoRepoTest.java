package io.pivotal.tg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.hateoas.PagedResources;
//import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DojoApplication.class)
@WebAppConfiguration
@IntegrationTest({"eureka.client.registerWithEureka:false", "eureka.client.fetchRegistry:false"})
public class JudoRepoTest {

    @Value("${local.server.port:8080}")
    int port;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void disciplineTechniques() throws Exception {
        String techniquesUrl = "http://localhost:" + port + "/techniques/search/findByDiscipline?discipline=bjj";

//        ParameterizedTypeReference<PagedResources<Resource<Technique>>> responseType
//                = new ParameterizedTypeReference<PagedResources<Resource<Technique>>>() {};
//
//        ResponseEntity<PagedResources<Resource<Technique>>> responseEntity =
//                restTemplate.exchange(techniquesUrl, HttpMethod.GET, null, responseType,  Collections.emptyMap());
//
//        PagedResources<Resource<Technique>> resources = responseEntity.getBody();
//        assertEquals(2, resources.getLinks().size());
    }

    @Test
    public void technique() throws Exception {
        String techniquesUrl = "http://localhost:" + port + "/techniques/1";

//        ParameterizedTypeReference<Resource<Technique>> responseType
//                                = new ParameterizedTypeReference<Resource<Technique>>() {};
//
//        ResponseEntity<Resource<Technique>> responseEntity =
//                restTemplate.exchange(techniquesUrl, HttpMethod.GET, null, responseType,  Collections.emptyMap());
//
//        Resource<Technique> technique = responseEntity.getBody();
//        assertEquals("bjj", technique.getContent().getDiscipline());
//        assertEquals("omoplata", technique.getContent().getName());
    }
}
