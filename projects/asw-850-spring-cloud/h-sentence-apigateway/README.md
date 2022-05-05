# Sentence (con Consul e Spring Cloud Consul Discovery, Spring Cloud LoadBalancer, Spring Cloud OpenFeign e Spring Cloud Circuit Breaker/Resilience4J)

Questo sottoprogetto mostra una versione dell'applicazione **sentence** che, oltre al servizio di service discovery, un load balancer lato client, client REST dichiarativi, circuit breaker, utilizza un API gateway (*Spring Cloud Gateway*). 

I servizi *word-service* e *sentence-service* agiscono da client nei confronti del servizio di service discovery. 

Il servizio *sentence-service* usa i client REST dichiarativi *OpenFeign* con un circuit breaker *Resilience4J* per accedere alle diverse istanze del servizio *word-service*. 

Il servizio *api-gateway* è un API Gateway che espone le funzionalità dell'applicazione sulla porta *8080*. 

Il servizio *sentence-service* può essere ora replicato. 

## Componenti eseguibili

Questa versione dell'applicazione **sentence** è formata dai seguenti componenti eseguibili: 

* **word-service** è il servizio per la generazione di parole casuali, che agisce da client nei confronti del servizio di service discovery, e che viene avviato con tre istanze: 
  * una con il profilo *subject* su una porta casuale, 
  * una con il profilo *verb* su una porta casuale, 
  * una con il profilo *object* su una porta casuale, 
* **sentence-service** è il servizio per la generazione delle frasi casuali, su una porta casuale, che agisce da client nei confronti dei servizi per le parole tramite il servizio di service discovery 
* **api-gateway** è un API gateway per esporre le funzionalità dell'intera applicazione sulla porta *8080*, anche lui protetto con un circuit breaker *Relisience4J*

## Esecuzione 

Per eseguire questa versione dell'applicazione: 

* avviare *Consul* eseguendo lo script `start-consul.sh` 

* per avviare l'applicazione *sentence* (compreso l'API gateway), eseguire lo script `run-sentence.sh` 

L'applicazione può essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh`. 

Alla fine, l'applicazione può essere arrestata usando lo script `kill-java-processes.sh` (**da usare con cautela!**). 

Inoltre, *Consul* può essere arrestato con lo script `stop-consul.sh`. 

### Altre modalità di esecuzione 

* lo script `run-sentence-with-delays.sh` introduce un ritardo sia nel servizio delle parole che nel servizio delle frasi 

* lo script `run-sentence-with-failures.sh` introduce la possibilità che uno o più servizi delle parole falliscano (con una certa probabilità) 

* lo script `run-sentence-replicated.sh` avvia due istanze del servizio *word-service* per ciascuno dei suoi tre profili, ma anche due istanze del servizio *sentence-service*

* gli script `run-sentence-replicated-with-delays.sh` e `run-sentence-replicated-with-failures.sh` avviano più istanze dei servizi per le parole e per le frasi, con l'introduzione di ritardi e la possibilità di fallimenti 

### Esperimenti 

Effettuare degli esperimenti, ispirandosi agli esperimenti suggeriti nei precedenti sottoprogetti. 

In particolare, è utile avviare una versione dell'applicazione che introduce ritardi (ciascun servizio delle parole e anche il servizio delle frasi introducono un ritardo di 50 millisecondi ciascuno).
Confrontare la latenza necessaria per il calcolo di una frase di questo progetto con quella del sottoprogetto successivo. 

