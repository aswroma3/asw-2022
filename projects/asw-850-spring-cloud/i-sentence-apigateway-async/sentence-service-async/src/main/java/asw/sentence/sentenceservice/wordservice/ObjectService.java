package asw.sentence.sentenceservice.wordservice;

import asw.sentence.sentenceservice.domain.WordAsyncService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;

import java.util.logging.Logger; 

@Service 
public class ObjectService implements WordAsyncService {

	private final Logger logger = Logger.getLogger(ObjectService.class.toString()); 

	@Autowired 
	private WordAsyncClient wordClient;
	
	public CompletableFuture<String> getWordAsync() {
		return wordClient.getWordAsync("object"); 
	}
	
}
