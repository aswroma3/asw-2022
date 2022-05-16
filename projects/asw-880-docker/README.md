# Docker (asw-880)

Questo progetto contiene alcuni esempi di contesti per la creazione di immagini e di container [Docker](https://www.docker.com/). 
I container possono essere creati ed eseguiti nell'ambiente [workstation](../../environments/workstation/). 

Sono proposti quattro progetti Docker: 

* il container [a-hello-world](a-hello-world), che quando avviato mostra un saluto 

* il container [b-apache-http-server](b-apache-http-server) per un server HTTP (che pubblica le pagine HTML nella cartella [`www/`](www/), gestita dall'host), che è raggiungibile sull'host alla porta 8080 

* il container [c-data-volume](c-data-volume), che gestisce un volume di pagine HTML da pubblicare con il server HTTP, alternativo al progetto precedente 

* il container [d-lucky-word](d-lucky-word/), che esemplifica l'esecuzione di un'applicazione web Spring Boot in un container Docker 

### Ambiente di esecuzione 

Questi container possono essere eseguiti nell'ambiente [workstation](../../environments/workstation/). 

