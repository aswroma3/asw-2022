package asw.sentence.sentenceservice.wordservice;

import java.util.concurrent.CompletableFuture;

public interface WordAsyncClient {

	public CompletableFuture<String> getWordAsync(String service); 

}
