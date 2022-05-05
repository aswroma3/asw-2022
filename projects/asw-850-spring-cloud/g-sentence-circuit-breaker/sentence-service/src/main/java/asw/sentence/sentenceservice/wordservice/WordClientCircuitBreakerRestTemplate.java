package asw.sentence.sentenceservice.wordservice;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;  

@Service 
// @Primary 
public class WordClientCircuitBreakerRestTemplate implements WordClient {

	@Autowired 
	@Qualifier("loadBalancedRestTemplate")
	private RestTemplate restTemplate;

	@Autowired 
	private CircuitBreakerFactory cbFactory;

	public String getWord(String service) {
		String serviceUri = "http://" + service; 
		return cbFactory
					.create(service)
					.run(() -> restTemplate.getForObject(serviceUri, String.class), throwable -> this.getFallbackWord());
	}	

	private String getFallbackWord() {
		String fallbackWord = "* fallback word *"; 
		return fallbackWord; 
	}
	
}
