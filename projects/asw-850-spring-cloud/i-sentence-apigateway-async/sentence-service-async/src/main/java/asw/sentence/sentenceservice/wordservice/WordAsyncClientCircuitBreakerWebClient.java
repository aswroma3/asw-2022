package asw.sentence.sentenceservice.wordservice;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;  

import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

@Service 
@Primary 
public class WordAsyncClientCircuitBreakerWebClient implements WordAsyncClient {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient webClient;
	
	@Autowired 
	private ReactiveCircuitBreakerFactory cbFactory;

	@Async
	public CompletableFuture<String> getWordAsync(String service) {
		return CompletableFuture.completedFuture(this.getWordWrapper(service)); 
	} 

	private String getWordWrapper(String service) {
		String word = null; 
		String serviceUri = "http://" + service; 
        Mono<String> response = webClient
                .get()
				.uri(serviceUri)
                .retrieve()
                .bodyToMono(String.class)
				.transform(
					it -> cbFactory
							.create(service)
							.run(it, throwable -> Mono.just(this.getFallbackWord())));
        try {
            word = response.block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return word; 
	}	
	
	private String getFallbackWord() {
		String fallbackWord = "* fallback word *"; 
		return fallbackWord; 
	}

}
