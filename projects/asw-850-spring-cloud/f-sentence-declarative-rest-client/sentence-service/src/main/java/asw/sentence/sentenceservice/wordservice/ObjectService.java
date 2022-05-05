package asw.sentence.sentenceservice.wordservice;

import asw.sentence.sentenceservice.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import feign.FeignException; 

import java.util.logging.Logger; 

@Service 
public class ObjectService implements WordService {

	private final Logger logger = Logger.getLogger(ObjectService.class.toString()); 

	@Autowired 
	private ObjectClient feignClient;
	
	public String getWord() {
		String word = null; 
		try {
			word = feignClient.getWord(); 
		} catch (FeignException e) {
			/* eccezione remota */ 
			word = "***"; 
		}
		return word; 
	}
	
}
