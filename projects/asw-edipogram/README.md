# EDIPOGRAM

Progetto del corso di Analisi e progettazione del software per l'anno accademico 2021-2022. 


## Descrizione di questo progetto 

Questo progetto contiene il il codice di *Edipogram*, 
un semplice social network per la condivisione di enigmi (ovvero, giochi enigmistici) di diversi tipi, come indovinelli ed anagrammi.  
Gli utenti del sistema possono pubblicare degli enigmi. 
Possono poi seguire gli enigmi di specifici tipi.  
Quando un utente accede alla pagina degli enigmi che segue, gli vengono mostrati gli enigmi dei tipi che segue. 

L'applicazione *Edipogram* è composta dai seguenti microservizi: 

* Il servizio *enigmi* gestisce gli enigmi. 
  Ogni enigma ha un autore, un tipo, una un tipo specifico, un titolo, un testo (che può essere composta da più righe) e una soluzione (che può essere composta da più parole). 
  Mentre autore, titolo, testo e soluzione hanno un significato ovvio, è utile discutere tipi e tipi specifici. 
  Un enigma potrebbe essere di tipo (generico) *Cambio* e di tipo specifico *Cambio di iniziale* oppure *Cambio di vocale*. 
  
  Un esempio di enigma: 
  * autore: Il Valletto
  * tipo: Cambio 
  * tipo specifico: Cambio di vocale (7)
  * titolo: Ponte pericolante
  * testo: Saldo non è... / e questo può esser grave!
  * soluzione: accOnto, accEnto
  
  Operazioni: 
  * `POST /enigmi` aggiunge un nuovo enigma (dati autore, tipo, titolo, testo e soluzione)
  * `GET /enigmi/{id}` trova un enigma, dato l'id 
  * `GET /enigmi/{id}/soluzione` trova la soluzione di un enigma, dato l'id 
  * `GET /enigmi` trova tutti gli enigmi (senza la soluzione)
  * `GET /cercaenigmi/autore/{autore}` trova tutti gli enigmi di un certo autore (senza soluzione)
  * `GET /cercaenigmi/autori/{elenco-di-autori}` trova tutti gli enigmi di un insieme di autori (senza soluzione) 
  * `GET /cercaenigmi/tipo/{tipo}` trova tutti gli enigmi di un certo tipo (senza soluzione)
  * `GET /cercaenigmi/tipi/{elenco-di-tipi}` trova tutti gli enigmi di un insieme di tipi (senza soluzione)
  
* Il servizio *connessioni* gestisce le connessioni degli utenti con i tipi di enigmi che essi seguono. 
  Le connessioni sono delle coppie *utente-tipo* . 
  Operazioni: 
  * `POST /connessioni` aggiunge una nuova connessione utente-tipo (dati utente e tipo)
  * `GET /connessioni` trova tutte le connessioni utente-tipo
  * `GET /connessioni/{utente}` trova tutte le connessioni utente-tipo di un certo utente

* Il servizio *enigmi-seguiti* consente a un utente di trovare gli enigmi di tutti i tipi che segue. 
  Operazioni: 
  * `GET /enigmiseguiti/{utente}` trova tutti gli enigmi seguiti da un certo utente, ovvero gli enigmi di tipi seguiti da quell'utente (gli enigmi sono senza soluzione)
  
* Il servizio *api-gateway* (esposto sulla porta *8080*) è l'API gateway dell'applicazione che: 
  * espone il servizio *enigmi* sul path `/enigmi` - ad esempio, `GET /enigmi/enigmi`
  * espone il servizio *connessioni* sul path `/connessioni` - ad esempio, `GET /connessioni/connessioni/{utente}`
  * espone il servizio *enigmi-seguiti* sul path `/enigmi-seguiti` - ad esempio, `GET /enigmi-seguiti/enigmiseguiti/{utente}`


## Esecuzione 

Per eseguire questo progetto: 

* avviare *Consul* eseguendo lo script `start-consul.sh` 

* per avviare l'applicazione *Edipogram*, eseguire lo script `run-edipogram.sh` 

* per inizializzare le basi di dati con dei dati di esempio, eseguire gli script `do-init-enigmi.sh` e `do-init-connessioni.sh` 


Sono anche forniti alcuni script di esempio: 

* lo script `run-curl-client.sh` esegue un insieme di interrogazioni di esempio 

* lo script `do-get-enigmi.sh` trova tutti gli enigmi 

* lo script `do-get-enigma.sh` trova un enigma 

* lo script `do-get-enigmi-di-autore.sh` trova tutti gli enigmi di un certo autore 

* lo script `do-get-enigmi-di-autori.sh` trova tutti gli enigmi di un insieme di autori  

* lo script `do-get-enigmi-di-tipo.sh` trova tutti gli enigmi di un certo tipo  

* lo script `do-get-enigmi-di-tipi.sh` trova tutti gli enigmi di un insieme di tipi  

* lo script `do-get-connessioni.sh` trova tutte le connessioni 

* lo script `do-get-enigmi-seguiti.sh` trova tutti gli enigmi seguiti da un certo utente 

Ed inoltre: 

* lo script `do-post-altri-enigmi.sh` aggiunge nuovi enigmi 

* lo script `do-post-altre-connessioni.sh` aggiunge nuove connessioni 

Alla fine, l'applicazione può essere arrestata usando lo script `kill-java-processes.sh` (**da usare con cautela!**). 

Inoltre, *Consul* può essere arrestato con lo script `stop-consul.sh`. 


## Descrizione delle attività da svolgere 

Si veda la descrizione del progetto sul sito web del corso di [Architettura dei sistemi software](http://cabibbo.dia.uniroma3.it/asw/).
