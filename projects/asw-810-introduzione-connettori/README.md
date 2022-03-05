# Introduzione ai connettori (asw-810)

Questo progetto contiene alcune semplici applicazioni 
per introdurre l'uso dei **connettori**: 

* **a-chiamata-locale**

* **b-factory**

* **c-iniezione-delle-dipendenze** 

* **d-application-context** 

* **e-proxy**

* **f-client-server** 

Solo l'ultima applicazione � un'applicazione distribuita. 
Tutte le altre sono applicazioni non distribuite. 
Ne descriviamo l'uso separatamente. 


## Applicazioni non distribuite (tutte tranne **f-client-server**) 

### Build  

Per la costruzione di ciascuna applicazione, vedere le istruzioni 
descritte nella sezione [projects/](../). 

### Componenti eseguibili 

Ciascuna di queste applicazioni � composta da un unico componente eseguibile. 

### Ambiente di esecuzione 

Ciascuna di queste applicazioni pu� essere eseguita direttamente sul proprio PC, 
oppure nell'ambiente [developer](../../environments/developer/), sul nodo **dev**. 

### Esecuzione 

Per eseguire un'applicazione: 

1. posizionarsi nella cartella principale dell'applicazione - ad esempio `~/projects/asw-810-introduzione-connettori/a-chiamata-locale`

2. eseguire il comando `gradle run` 


## L'applicazione distribuita **f-client-server** 

### Build  

Per la costruzione dell'applicazione, vedere le istruzioni 
descritta nella sezione [projects/](../). 

### Componenti eseguibili 

Questa applicazione � composta da due componenti eseguibili (**server** e **client**). 
I componenti comunicano sulla porta **6789** del **server**. 

### Ambiente di esecuzione 

Anche questa applicazione pu� essere eseguita direttamente sul proprio PC 
(oppure nell'ambiente [developer](../../environments/developer/), sul nodo **dev**), 
utilizzando per� due finestre (terminali) diverse: 
una per il **server** e una per il **client**. 

### Esecuzione 

Per eseguire questa applicazione si proceda in questo modo: 

1. sulla finestra (terminale) nodo **server** 

   a. posizionarsi nella cartella principale dell'applicazione - in questo caso, `~/projects/asw-810-introduzione-connettori/f-client-server`

   b. eseguire il comando `gradle server:run` 
   
   c. alla fine, il server pu� essere arrestato con CTRL-C 

2. sulla finestra **client** 

   a. posizionarsi nella cartella principale dell'applicazione - in questo caso, `~/projects/asw-810-introduzione-connettori/f-client-server`

   b. eseguire il comando `gradle client:run` oppure il comando `gradle client:run --args 10.11.1.111` 
      (`10.11.1.111` � l'indirizzo IP del nodo **dev**, in cui � in esecuzione il **server**) 
	  oppure il comando `gradle client:run --args indirizzo-server-remoto` (per accedere ad un server remoto)
