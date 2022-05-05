package asw.sentence.sentenceservice.wordservice;

import asw.sentence.sentenceservice.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import feign.FeignException; 

import java.util.logging.Logger; 

@Service 
public class SubjectService implements WordService {

	private final Logger logger = Logger.getLogger(SubjectService.class.toString()); 

	@Autowired 
	private SubjectClient feignClient;

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
