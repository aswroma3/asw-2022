# Invocazione remota con REST (asw-835)

Questo progetto contiene alcune applicazioni 
che esemplificano l'invocazione remota con **REST**:  

* **a-hello** � un esempio minimale di applicazione client-server basata su REST  

* **b-restaurant** � l'applicazione per la gestione di ristoranti (gi� definita in un precedente progetto),
  che ora espone i suoi servizi mediante REST e con un client REST 

* **c-restaurant-with-menu** estende l'applicazione precedente con la gestione dei menu dei ristoranti 

Le diverse applicazioni hanno una struttura simile, 
e la loro costruzione ed esecuzione � descritta qui di seguito. 

### Build  

Per la costruzione di ciascuna applicazione, vedere le istruzioni 
descritte nella sezione [projects/](../). 

In pratica, per compilare e assemblare ciascuna applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-835-rest/a-hello`

2. per compilare e assemblare l'applicazione, usare il comando `gradle build` 

### Componenti eseguibili 

Queste applicazioni sono tutte composte da due componenti eseguibili (un componente server e un componente client). 
Le applicazioni web possono essere accedute sulla porta **8080** dell'host, 
sia se eseguite sul proprio PC che se vengono eseguite 
nell'ambiente [developer](../../environments/developer/), sul nodo **dev**. 

### Ambiente di esecuzione 

Ciascuna di queste applicazioni pu� essere eseguita direttamente sul proprio PC, 
oppure nell'ambiente [developer](../../environments/developer/), sul nodo **dev**. 
Vanno per� utilizzate due finestre (terminali) diverse: una per il **server** e una per il **client**. 

### Esecuzione 

Per eseguire l'applicazione **a-hello** si proceda come segue: 

1. sulla finestra (terminale) nodo **server** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-835-rest/a-hello`

   b. eseguire il comando `gradle hello-server:bootRun` 
   
   c. il server pu� essere arrestato con CTRL-C 

2. sulla finestra **client** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-835-rest/a-hello`

   b. eseguire il comando `gradle hello-client:bootRun` (basato su *WebClient*)
   
   c. in alternativa, usare il comando `./run-curl-client.sh` per eseguire un semplice client bash/curl anzich� il client Java 

   c. per utilizzare invece il client basato su *RestTemplate*, eseguire il comando `gradle hello-client-resttemplate:bootRun` 

Per eseguire le applicazioni **b-restaurant** e **c-restaurant-with-menu** si proceda come segue: 

1. sulla finestra (terminale) nodo **server** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-835-rest/b-restaurant` oppure `~/projects/asw-835-rest/c-restaurant-with-menu`

   b. eseguire il comando `gradle restaurant-server:bootRun` 
   
   c. il server pu� essere arrestato con CTRL-C 

2. sulla finestra **client** 

   a. posizionarsi nella cartella principale dell'applicazione `~/projects/asw-835-rest/b-restaurant` oppure `~/projects/asw-835-rest/c-restaurant-with-menu`

   b. eseguire il comando `gradle restaurant-client-rest:bootRun` (utilizza il client sincrono) 
   
   c. per utilizzare il client asincrono, eseguire il comando `gradle restaurant-async-client-rest:bootRun` 

