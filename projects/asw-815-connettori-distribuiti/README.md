# Connettori distribuiti e comunicazione client-server (asw-815)

Questo progetto contiene alcune applicazioni distribuite di tipo **client-server**
che esemplificano la realizzazione di semplici connettori distribuiti, 
basati sulla comunicazione interprocesso con i **socket**: 

* **a-client-server-udp** 
  una semplice applicazione client-server, 
  con un server *sequenziale* e *stateless* basato su *UDP* 
  (i componenti comunicano sulla porta **6789** del **server**) 

* **b-client-server-tcp**
  una semplice applicazione client-server, 
  con un server *concorrente* e *stateless* basato su *TCP* 
  (i componenti comunicano sulla porta **7896** del **server**) 

* **c-stateful-service** 
  una semplice applicazione client-server, 
  con un server *concorrente* e *stateful* basato su *TCP* 
  (i componenti comunicano sulla porta **7869** del **server**) 

Le diverse applicazioni hanno una struttura simile, 
e la loro costruzione ed esecuzione � descritta qui di seguito. 

## Build  

Per la costruzione di ciascuna di queste applicazioni, 
vedere le istruzioni descritte nella sezione [projects/](../). 

## Componenti eseguibili 

Ciascuna applicazione � composta da due componenti eseguibili (**server** e **client**). 

## Ambiente di esecuzione 

Anche questa applicazione pu� essere eseguita direttamente sul proprio PC 
(oppure nell'ambiente [developer](../../environments/developer/), sul nodo **dev**), 
utilizzando per� due finestre (terminali) diverse: 
una per il **server** ed una per il **client**. 

## Esecuzione 

Per eseguire un'applicazione si proceda in questo modo: 

1. sulla finestra (terminale) nodo **server** 

   a. posizionarsi nella cartella principale dell'applicazione - ad esempio, `~/projects/asw-815-socket/a-client-server-udp`

   b. eseguire il comando `gradle server:run` 
   
   c. il server pu� essere arrestato con CTRL-C 

2. sulla finestra **client** 

   a. posizionarsi nella cartella principale dell'applicazione - ad esempio, `~/projects/asw-815-socket/a-client-server-udp`

   b. eseguire il comando `gradle client:run` oppure il comando `gradle client:run --args 10.11.1.111` 
      (`10.11.1.111` � l'indirizzo IP del nodo **dev**, in cui � in esecuzione il **server**) 
	  oppure il comando `gradle client:run --args indirizzo-server-remoto` (per accedere a un server remoto)


