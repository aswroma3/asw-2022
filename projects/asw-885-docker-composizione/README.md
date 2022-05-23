# Composizione di container Docker (asw-885)

Questo progetto contiene alcune applicazioni che esemplificano il rilascio di applicazioni composte da uno o pi� servizi, eseguite mediante la composizione di container Docker. 

In particolare, le applicazioni sono in genere delle varianti dell'applicazione distribuita **sentence**, descritta nel progetto [asw-850-spring-cloud/](../asw-850-spring-cloud/). 

* [a-sentence-docker](a-sentence-docker/): per eseguire l'applicazione **sentence** come composizione di container, usando solo *Docker*

* [b-sentence-docker-compose](b-sentence-docker-compose/): per eseguire l'applicazione **sentence** come composizione di container, usando *Docker Compose*

**Le due versioni di questa applicazione utilizzano esattamente lo stesso codice per i progetti Java**. 
Tuttavia, nei due progetti cambia la modalit� di gestione delle immagini e dei container Docker. 

## Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno per� utilizzate pi� finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client.  

