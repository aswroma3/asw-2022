package asw.edipogram.enigmiseguiti.connessioni;

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

@Service 
@Primary 
public class ConnessioniServiceWebClient implements ConnessioniService {

	@Autowired 
	@Qualifier("loadBalancedWebClient")
    private WebClient loadBalancedWebClient;
	
	public Collection<Connessione> getConnessioniByUtente(String utente) {
		Collection<Connessione> connessioni = null; 
        Flux<Connessione> response = loadBalancedWebClient
                .get()
				.uri("http://connessioni/connessioni/{utente}", utente)
                .retrieve()
                .bodyToFlux(Connessione.class);
        try {
            connessioni = response.collectList().block();
        } catch (WebClientException e) {
            e.printStackTrace();
        }
		return connessioni; 
	}	

}
