package asw.sentence.sentenceservice.wordservice;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException; 

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.ServiceInstance;

@Service 
// @Primary 
public class WordClientLoadBalancerClientRestTemplate implements WordClient {

	@Autowired 
	private LoadBalancerClient loadBalancer;

	@Autowired 
	private RestTemplate restTemplate;

	public String getWord(String service) {
		String word = null; 
		URI uri = getWordUri(service); 
		if (uri!=null) {
			word = restTemplateGet(uri); 
		} else {
			/* nessuna istanza del servizio disponibile */ 
			word = "###"; 
		}
		return word; 
	}

	private String restTemplateGet(URI uri) {
		String word = null; 
		try {
			word = restTemplate.getForObject(uri, String.class);
		} catch (RestClientException e) {
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

