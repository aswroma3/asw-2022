package asw.sentence.sentenceservice.wordservice;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;  

import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

@Service 
// @Primary 
public class WordAsyncClientCircuitBreakerRestTemplate implements WordAsyncClient {

	@Autowired 
	@Qualifier("loadBalancedRestTemplate")
	private RestTemplate restTemplate;

	@Autowired 
	private CircuitBreakerFactory cbFactory;

	@Async
	public CompletableFuture<String> getWordAsync(String service) {
		return CompletableFuture.completedFuture(this.getWordWrapper(service)); 
	} 

	private String getWordWrapper(String service) {
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
