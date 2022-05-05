# Sentence (con Consul e Spring Cloud Consul Discovery, Spring Cloud LoadBalancer e Spring Cloud OpenFeign)

Questo sottoprogetto mostra una versione dell'applicazione **sentence** che, oltre al servizio di service discovery, un load balancer lato client, utilizza client REST dichiarativi e generati dinamicamente (*Spring Cloud OpenFeign*). 

I servizi *word-service* e *sentence-service* agiscono da client nei confronti del servizio di service discovery. 

Il servizio *sentence-service* usa i client REST dichiarativi *OpenFeign* per accedere alle diverse istanze del servizio *word-service*. 

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

