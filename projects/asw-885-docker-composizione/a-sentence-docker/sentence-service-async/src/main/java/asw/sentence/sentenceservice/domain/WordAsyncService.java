package asw.sentence.sentenceservice.domain;

import java.util.concurrent.CompletableFuture;

public interface WordAsyncService {

	public CompletableFuture<String> getWordAsync(); 
	
}
