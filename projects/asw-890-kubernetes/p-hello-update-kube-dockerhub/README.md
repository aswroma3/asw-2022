# Hello (versione k8s)

Questo sottoprogetto contiene il codice per una semplice applicazione web Spring Boot 
da eseguire su Kubernetes. 

## Componenti eseguibili

Questa applicazione **hello** è formata da un solo componente eseguibile.

## Ambiente di esecuzione 

Questa applicazione può essere costruita ed eseguita nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione ed una per il suo client.  

## Build (Java) 

Per la costruzione dell'applicazione, eseguire il comando `gradle assemble` oppure `gradle build`

## Build (Docker) - OPZIONALE 

*Questo passo è necessario solo se si vogliono utilizzare delle immagini Docker diverse da quelle predisposte dal docente del corso.*

Per la costruzione delle immagini Docker ed effettuare il push su Docker Hub: 

* accedere a Docker Hub, eseguendo il comando `docker login` (è necessaria la registrazione a Docker Hub)

* modificare i file `build-and-push-docker-image.sh` e `run-hello-service.sh`, usando il nome del proprio account su Docker Hub al posto di **aswroma3** 

* eseguire lo script `build-and-push-docker-image.sh` 

## Esecuzione (locale) 

Per avviare l'applicazione sul nodo **workstation**, eseguire il comando `gradle bootRun`. 

L'applicazione *hello* espone un servizio REST sulla porta **8080**, 
ed è possibile ottenere un saluto all'indirizzo `localhost:8080`.

In pratica, l'applicazione può essere verificata usando lo script `run-curl-client.sh` (alla fine va arrestato con **CTRL-C**). 

## Arresto 

Si può arrestare l'applicazione con **CTRL-C** 





