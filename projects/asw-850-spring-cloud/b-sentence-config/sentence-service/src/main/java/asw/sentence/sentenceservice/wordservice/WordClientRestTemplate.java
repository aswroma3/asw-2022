package asw.sentence.sentenceservice.wordservice;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException; 

@Service 
// @Primary 
public class WordClientRestTemplate implements WordClient {

	@Autowired 
	private RestTemplate restTemplate;
	
	public String getWord(String wordUri) {
		String word = null; 
		try {
			word = restTemplate.getForObject(wordUri, String.class);
		} catch (RestClientException e) {
            /* eccezione remota */ 
			word = "***"; 
        }
		return word; 
	}	

}
