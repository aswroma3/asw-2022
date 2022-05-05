package asw.sentence.sentenceservice.wordservice;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.ServiceInstance;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

@Service 
// @Primary 
public class WordClientLoadBalancerClientWebClient implements WordClient {

	@Autowired 
	private LoadBalancerClient loadBalancer;

    @Autowired
	private WebClient webClient;
	
	public String getWord(String service) {
		String word = null; 
		URI uri = getWordUri(service); 
		if (uri!=null) {
			word = webClientGet(uri); 
		} else {
			/* nessuna istanza del servizio disponibile */ 
			word = "###"; 
		}
		return word; 
	}	

	private String webClientGet(URI uri) {
		String word = null; 
        Mono<String> response = webClient
                .get()
				.uri(uri)
                .retrieve()
                .bodyToMono(String.class);
        try {
            word = response.block();
        } catch (WebClientException e) {
            /* eccezione remota */ 
			word = "***";
        }
		return word; 
	}	

	private URI getWordUri(String service) {
		URI uri = null; 
		ServiceInstance instance = loadBalancer.choose(service);
		if (instance!=null) {
			uri = instance.getUri();
		}
		return uri; 
	} 

}

