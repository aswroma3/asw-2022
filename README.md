# Architettura dei Sistemi Software a Roma Tre (2022)

Benvenuti al repository del corso 
di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/) 
a Roma Tre, 
edizione 2022 (A.A. 2021-2022), 
tenuto dal prof. [Luca Cabibbo](http://cabibbo.dia.uniroma3.it/). 

Questo repository contiene il codice delle *esercitazioni* 
del corso di [Architettura dei Sistemi Software](http://cabibbo.dia.uniroma3.it/asw/), 
che sono relative a delle semplici *applicazioni software distribuite* 
(basate sull'uso di *middleware*), 
che vanno eseguite in degli opportuni *ambienti distribuiti*: 
* il software � normalmente scritto in [Java](http://www.oracle.com/technetwork/java/index.html), 
  e costruito con [Gradle](http://gradle.org/); 
* ciascun ambiente di esecuzione distribuito � composto da una o pi� macchine virtuali create con 
  [VirtualBox](https://www.virtualbox.org/) e [Vagrant](https://www.vagrantup.com/), 
  e accedute tramite [Git](https://git-scm.com/); 
* inoltre, alcuni ambienti di esecuzione sono basati sui container [Docker](https://www.docker.com/)
  e sull'orchestrazione di container [Kubernetes](https://kubernetes.io/)

## Software da installare sul proprio PC 

### Per la gestione degli ambienti di esecuzione  

* [VirtualBox](https://www.virtualbox.org/)
* [Vagrant](https://www.vagrantup.com/) 
* [Git](https://git-scm.com/) 
* opzionalmente [Docker](https://www.docker.com/), 
  che per� non � strettamente necessario, poich� pu� essere eseguito nelle macchine virtuali. 

### Per lo sviluppo del software 

Ecco il software opzionale per lo sviluppo del software (non � strettamente necessario, poich� pu� essere eseguito nelle macchine virtuali):
* [Java SDK](http://www.oracle.com/technetwork/java/javase/) 
* [Gradle](http://gradle.org/) 

## Organizzazione del repository 

Questo repository � organizzato in diverse sezioni (cartelle): 
* [projects](projects/) contiene il codice delle *applicazioni distribuite*, 
  con una sottosezione (sottocartella) per ciascuno degli argomenti del corso; 
* [environments](environments/) contiene il codice per la gestione degli *ambienti distribuiti*, 
  con una sottosezione (sottocartella) per ciascuno degli ambienti distribuiti 
  su cui poter eseguire le applicazioni distribuite sviluppate; 
* [shared](shared/) contiene ulteriori risorse condivise per la gestione degli *ambienti distribuiti*. 

Queste sezioni non sono indipendenti, ma correlate (in modo non banale). 
<!---
Per esempio, il progetto **hello-rmi** (in [projects](projects/))
va eseguito nell'ambiente **client-server** (in [environments](environments/)). 
-->

Attualmente non sono presenti tutti i progetti e nemmeno tutti gli ambienti. 
Verranno aggiunti a questo repository durante lo svolgimento del corso. 

## Accesso al repository 

Per effettuare il download del repository, usare il seguente comando Git 
dalla cartella locale in cui si vuole scaricare il repository: 

    git clone https://github.com/aswroma3/asw 

Oppure (se il sistema host � Windows): 

    git clone --config core.autocrlf=input https://github.com/aswroma3/asw 

Per aggiornare il contenuto della propria copia locale del repository, 
usare il seguente comando Git dalla cartella locale in cui � stato scaricato il repository: 

    git pull 
