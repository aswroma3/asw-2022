package asw.edipogram.enigmiseguiti.enigmi;

import asw.edipogram.enigmiseguiti.domain.*; 

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*; 
import java.util.stream.*; 

@Service 
@Primary 
public class EnigmiServiceWebClient implements EnigmiService {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<Enigma> getEnigmiByTipi(Collection<String> tipi) {
		Collection<Enigma> enigmi = null; 
        Flux<Enigma> response = loadBalancedWebClient
                .get()
				.uri("http://enigmi/cercaenigmi/tipi/{tipi}", toString(tipi))
                .retrieve()
                .bodyToFlux(Enigma.class);
        try {
            enigmi = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return enigmi; 
	}	

	private static String toString(Collection<String> c) {
		String result = 
			c.stream()
				.map(n -> String.valueOf(n))
				.collect(Collectors.joining(",", "", ""));
		return result; 
	}

}
