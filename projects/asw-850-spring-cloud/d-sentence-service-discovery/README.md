# Sentence (con Consul e Spring Cloud Consul Discovery)

Questo sottoprogetto mostra una versione dell'applicazione **sentence** che utilizza un servizio di service discovery (*Consul*). 

I servizi *word-service* e *sentence-service* agiscono da client nei confronti del servizio di service discovery. 

Il servizio *sentence-service* usa il *discovery client* di *Spring Cloud Consul Discovery* per accedere alle diverse istanze del servizio *word-service*. 

**Nota:** Questa versione dell'applicazione (come le successive) non utilizza più il configuration server. 

## Componenti eseguibili

Questa versione dell'applicazione **sentence** è formata dai seguenti componenti eseguibili: 

* **word-service** è il servizio per la generazione di parole casuali, che agisce da client nei confronti del servizio di service discovery, e che viene avviato con tre istanze: 
  * una con il profilo *subject* su una porta casuale, 
  * una con il profilo *verb* su una porta casuale, 
  * una con il profilo *object* su una porta casuale, 
* **sentence-service** è il servizio per la generazione delle frasi casuali, sulla porta *8080*, che agisce da client nei confronti dei servizi per le parole tramite il servizio di service discovery 

## Esecuzione 

Per eseguire questa versione dell'applicazione: 

* avviare *Consul* eseguendo lo script `start-consul.sh` 

* per avviare l'applicazione *sentence*, eseguire lo script `run-sentence.sh` 

L'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh`. 

Alla fine, l'applicazione può essere arrestata usando lo script `kill-java-processes.sh` (**da usare con cautela!**). 

Inoltre, *Consul* può essere arrestato con lo script `stop-consul.sh`. 

### Altre modalità di esecuzione 

* lo script `run-sentence-with-delays.sh` introduce un ritardo sia nel servizio delle parole che nel servizio delle frasi 

* lo script `run-sentence-with-failures.sh` introduce la possibilità che uno o più servizi delle parole falliscano (con una certa probabilità) 

* lo script `run-sentence-replicated.sh` avvia due istanze del servizio *word-service* per ciascuno dei suoi tre profili (ma una sola istanza del servizio *sentence-service*)

* gli script `run-sentence-replicated-with-delays.sh` e `run-sentence-replicated-with-failures.sh` avviano più istanze dei servizi per le parole, con l'introduzione di ritardi e la possibilità di fallimenti 

### Esperimenti 

Durante l'esecuzione dell'applicazione, è possibile: 

* Uccidere gentilmente (usando il comando *kill -15*) il processo di uno o più dei servizi delle parole. 
  Per uccidere gentilmente un'istanza del servizio *subject per il soggetto si può anche usare il comando `kill-15-a-java-process.sh subject`.
  Eseguire questo esperimento, usando come client lo script `run-curl-client-forever.sh` per almeno un minuto. 

* Uccidere brutalmente (usando il comando *kill -9*) il processo di uno o più dei servizi delle parole. 
  Per uccidere brutalmente un'istanza del servizio *subject per il soggetto si può anche usare il comando `kill-9-a-java-process.sh subject`.
  Eseguire questo esperimento, usando come client lo script `run-curl-client-forever.sh` per almeno un minuto. 
