package asw.rest.hello.client.hello.rest;

import asw.rest.hello.client.domain.HelloServiceAdapter;

import java.util.logging.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Service
public class HelloServiceAdapterRestRestTemplateImpl implements HelloServiceAdapter {

    private Logger logger = Logger.getLogger(HelloServiceAdapterRestRestTemplateImpl.class.toString());

    @Value("${asw.rest.hello.service.uri}")
    private String helloServiceUri;

    private RestTemplate restTemplate = new RestTemplate();

	/* Invoca sayHello. */ 
    public String sayHello(String name) {
        logger.info("sayHello(" + name + ") [RESTTEMPLATE]");
		String greeting = null; 
        try {
			greeting = restTemplate.getForObject(helloServiceUri + "/hello/{name}", String.class, name);
        } catch (RestClientException e) {
            logger.info("sayHello(" + name + ") [RESTTEMPLATE] exception: " + e.getMessage());
        }
		logger.info("sayHello(" + name + ") [RESTTEMPLATE]: " + greeting);
		return greeting; 
    }

}
