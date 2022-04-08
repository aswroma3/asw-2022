# asw-840-kafka/c-restaurant

Questo progetto � � l'applicazione per la gestione di ristoranti (gi� definita in un precedente progetto), con cui � ora possibile interagire anche in modo asincrono.


## Componenti eseguibili 

Questa applicazione � composta da tre componenti eseguibili: 

* **restaurant-server** � il servizio per la gestione dei ristoranti (con un'interfaccia web e REST)

* **restaurant-client-event-listener** � un ascoltatore di eventi relativi ai ristoranti, che effettua il log degli eventi pubblicati dal servizio dei ristoranti 

* **restaurant-client-command** � un produttore di comandi relativi ai ristoranti, che quando viene eseguito genera comandi per la creazione di due nuovi ristoranti 


## Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno per� utilizzate pi� finestre (terminali) diverse, una per ciascun componente eseguibile dell'applicazione. 


## Preparazione 

Preliminarmente all'esecuzione dell'applicazione � necessario avviare la sua infrastruttura (composta da **Kafka** e **Postgres**) come segue: 

* sul nodo **workstation**, posizionarsi nella cartella principale di questo progetto `~/projects/asw-840-kafka/c-restaurant/`

* eseguire lo script `start-infrastructure.sh`, che avvia Kafka e Postgres, e crea i topic necessari per l'applicazione 


Inoltre, dopo aver eseguito l'applicazione � necessario arrestare **Kafka** e **Postgres**, come segue: 

* sul nodo **workstation**, posizionarsi nella cartella principale di questo progetto `~/projects/asw-840-kafka/c-restaurant/`

* eseguire lo script `stop-infrastructure.sh` 


## Esecuzione 

Per eseguire l'applicazione (dopo la *Preparazione*), vanno utilizzate tre (o pi�) finestre (terminali) diverse: una per il **server** del servizio dei ristoranti, una per l'**ascoltatore** di eventi e una per il **produttore** di comandi. 

Si proceda in questo modo: 

1. sulla finestra (terminale) nodo **ascoltatore** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/c-restaurant/`

   b. eseguire il comando `gradle restaurant-client-event-listener:bootRun` 
   
   c. l'ascoltatore di eventi pu� essere arrestato con CTRL-C 

2. sulla finestra (terminale) nodo **server** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/c-restaurant/`

   b. eseguire il comando `gradle restaurant-server:bootRun` 
   
   c. il servizio pu� essere arrestato con CTRL-C 

3. sulla finestra **produttore** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-840-kafka/c-restaurant/`

   b. eseguire il comando `gradle restaurant-client-command:bootRun` 

