# Lucky word

Questo sottoprogetto esemplifica come eseguire un'applicazione web Spring Boot 
in un contenitore Docker. 

## Esecuzione 

Ci sono due modi per eseguire questa applicazione: 

* costruire l'immagine Docker localmente e poi creare e avviare un container Docker da questa immagine locale 

* poi creare e avviare un container Docker da un'immagine su Docker Hub 

Esaminiamo le due modalità separatamente. 


### Esecuzione con immagine Docker locale 

Per prima cosa, è necessario effettuare la build (Java) dell'applicazione con Gradle,  
nell'ambiente [workstation](../../../environments/workstation/), 
sempre essendo posizionati nella cartella del sotto progetto: 

* eseguire `gradle build` nella cartella del sottoprogetto 

Poi bisogna costruire e mandare in esecuzione l'applicazione in un container Docker, 
operando sempre nell'ambiente [workstation](../../../environments/workstation/) 
e sempre essendo posizionati nella cartella del sotto progetto: 

* eseguire il comando `docker image build --rm -t lucky-word .` 
 
* eseguire il comando `docker container run -d -p 8080:8080 --name=lucky-word lucky-word` 
  
* in alternativa, eseguire il comando `docker container run -d -p 8080:8080 --name=lucky-word lucky-word -jar -Dspring.profiles.active=english lucky-word.jar` 
  oppure il comando `docker container run -d -p 8080:8080 --name=lucky-word lucky-word -jar -Dspring.profiles.active=italian lucky-word.jar` 
  per utilizzare un profilo differente 

Il contenitore espone il suo servizio sulla porta `8080`, 
che è anche collegata alla porta `8080` della macchina virtuale **workstation**, 
sul path `/lucky-word`. 
Pertanto, il servizio sarà accessibile nella macchina virtuale **workstation** 
all'indirizzo `localhost:8080/lucky-word` 
(si veda lo script `run-curl-client.sh`). 

Sull'host, potrebbe essere accessibile ad una porta diversa, 
in genere sulla porta `8080` o sulla porta `8081` (vedere il port forwarding dell'ambiente). 


### Esecuzione con immagine Docker da Docker Hub  

In questo caso, non è necessario è necessario effettuare la build (Java) dell'applicazione. 
Anzi, non è nemmeno necessario il codice sorgente dell'applicazione. 

Poi invece mandare in esecuzione l'applicazione in un container Docker, 
operando nell'ambiente [workstation](../../../environments/workstation/),  
posizionati nella cartella del sotto progetto: 

* eseguire il comando `docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word` 
  oppure lo script `run-container.sh`
  
* in alternativa, eseguire il comando `docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word -jar -Dspring.profiles.active=english lucky-word.jar` 
  oppure il comando `docker container run -d -p 8080:8080 --name=lucky-word lucky-word -jar -Dspring.profiles.active=italian lucky-word.jar` 
  oppure il comando `docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word -jar -Dspring.profiles.active=italian lucky-word.jar` 
  oppure gli script `run-container-as-english.sh` o `run-container-as-italian.sh`
  per utilizzare un profilo differente 

Il contenitore espone il suo servizio sulla porta `8080`, 
che è anche collegata alla porta `8080` della macchina virtuale **workstation**, 
sul path `/lucky-word`. 
Pertanto, il servizio sarà accessibile nella macchina virtuale **workstation** 
all'indirizzo `localhost:8080/lucky-word` 
(si veda lo script `run-curl-client.sh`). 

Sull'host, potrebbe essere accessibile ad una porta diversa, 
in genere sulla porta `8080` o sulla porta `8081` (vedere il port forwarding dell'ambiente). 