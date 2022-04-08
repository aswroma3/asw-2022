# asw-840-kafka/b-simple-pipeline

Questo progetto � una semplice applicazione con un produttore di messaggi, un filtro di messaggi e un consumatore di messaggi.


## Componenti eseguibili 

Questa applicazione � composta da tre componenti eseguibili: 

* **simple-producer** � un componente produttore di messaggi 

* **simple-filter** � un componente filtro di messaggi 

* **simple-consumer** � un componente consumatore di messaggi 


## Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno per� utilizzate pi� finestre (terminali) diverse, una per ciascun componente eseguibile dell'applicazione. 


## Preparazione 

Preliminarmente all'esecuzione dell'applicazione � necessario avviare **Kafka**, come segue: 

* sul nodo **workstation**, posizionarsi nella cartella principale del progetto `~/projects/asw-840-kafka/` 

* eseguire lo script `start-kafka.sh` 

* eseguire lo script `create-some-kafka-topics.sh`, che crea i topic *asw.alpha*, *asw.beta* e *asw-gamma* 


Inoltre, dopo aver eseguito l'applicazione � necessario arrestare **Kafka**, come segue: 

* sul nodo **workstation**, posizionarsi nella cartella principale del progetto `~/projects/asw-840-kafka/` 

* eseguire lo script `stop-kafka.sh` 


## Esecuzione 

Per eseguire l'applicazione (dopo la *Preparazione*), vanno utilizzate tre (o pi�) finestre (terminali) diverse: 
una per il **consumatore**, una per il **filtro** e una per il **produttore**. 

Si proceda in questo modo: 

1. sulla finestra (terminale) nodo **consumatore** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/b-simple-pipeline`

   b. eseguire il comando `gradle simple-consumer:bootRun` 
   
   c. il consumatore pu� essere arrestato con CTRL-C 

2. sulla finestra (terminale) nodo **filtro** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/b-simple-pipeline`

   b. eseguire il comando `gradle simple-filter:bootRun` 
   
   c. il filtro pu� essere arrestato con CTRL-C 

3. sulla finestra **produttore** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/b-simple-pipeline`

   b. eseguire il comando `gradle simple-producer:bootRun` 

