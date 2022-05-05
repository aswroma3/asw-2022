package asw.sentence.sentenceservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;

@Service 
public class SentenceService {

	@Autowired 
	private WordAsyncService subjectService;

	@Autowired 
	private WordAsyncService verbService;

	@Autowired 
	private WordAsyncService objectService;

	public String getSentence() {
		CompletableFuture<String> futureSubject = subjectService.getWordAsync(); 
		CompletableFuture<String> futureVerb = verbService.getWordAsync(); 
		CompletableFuture<String> futureObject = objectService.getWordAsync(); 
		CompletableFuture.allOf(futureSubject, futureVerb, futureObject).join();
		String sentence = null; 
		try {
			sentence = futureSubject.get() + " " + futureVerb.get() + " " + futureObject.get() + ".";
		} catch (Exception e) {
			sentence = "*****"; 
		}
		return sentence; 
	}

}
