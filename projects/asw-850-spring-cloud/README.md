# Spring Cloud (asw-850)

Questo progetto contiene alcune applicazioni che esemplificano l'uso di [Spring Cloud](https://spring.io/projects/spring-cloud) per la realizzazione di applicazioni *multi-servizi*. 

Gli esempi sono tutti relativi a un'applicazione distribuita **sentence**, il cui scopo � di generare delle semplici frasi casuali. 
L'applicazione viene mostrata in pi� versioni.  

* [a-sentence-basic](a-sentence-basic/): la versione di base  

* [b-sentence-config](b-sentence-config/): uso di un servizio di configurazione: [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)

* [c-sentence-config-refresh](c-sentence-config-refresh/): uso di un servizio di configurazione, con refresh (statico e dinamico) delle configurazioni 

* [d-sentence-discovery-service](d-sentence-discovery-service/): uso di un servizio di service discovery: [Consul](https://www.consul.io/) e [Spring Cloud Consul](https://spring.io/projects/spring-cloud-consul) 

* [e-sentence-load-balancer](e-sentence-load-balancer/): uso di un load balancer lato client: [Spring Cloud LoadBalancer](https://spring.io/guides/gs/spring-cloud-loadbalancer/)

* [f-sentence-declarative-rest-client](f-sentence-declarative-rest-client/): uso di un client REST dichiarativo: [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)

* [g-sentence-circuit-breaker](g-sentence-circuit-breaker/): uso di un circuit breaker: [Spring Cloud Circuit Breaker](https://spring.io/projects/spring-cloud-circuitbreaker) e [Resilience4J](https://github.com/resilience4j/resilience4j)

* [h-sentence-apigateway](h-sentence-apigateway/): uso di un API gateway: [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

* [i-sentence-apigateway-async](i-sentence-apigateway-async/): uso di chiamate REST asincrone e concorrenti 

Le diverse versioni di questa applicazione hanno una struttura simile (ma di volta in volta un po' diversa), e la loro costruzione ed esecuzione � descritta qui di seguito. 

## Build  

Per la costruzione di ciascuna versione dell'applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-850-spring-cloud/a-sentence-basic`

2. per compilare e assemblare l'applicazione, usare il comando `gradle build` 

## Componenti eseguibili 

Ciascuna versione dell'applicazione � composta da due o pi� componenti eseguibili. 
Per la descrizione dei componenti eseguibili, vedere il file README nella cartella di ciascun sottoprogetto. 

### Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [workstation](../../environments/workstation/), sul nodo **workstation**. 
Vanno per� utilizzate pi� finestre (terminali) diverse. In genere, una per l'applicazione *sentence* e una per il suo client.  

### Esecuzione 

Per l'esecuzione delle diverse versioni dell'applicazione, vedere il file README nella cartella di ciascun sottoprogetto. 

In generale, per eseguire una versione dell'applicazione, bisogna avviare individualmente i servizi che la compongono. Ciascuna versione dell'applicazione contiene gli script necessari ad avviare l'applicazione. 

**Attenzione**: l'avvio dell'applicazione *sentence* pu� richiedere da qualche secondo a qualche minuto. 

Complessivamente, l'applicazione *sentence* espone un servizio REST sulla porta **8080** del nodo **workstation**, 
ed � possibile ottenere una frase casuale all'indirizzo `localhost:8080`.

In pratica, l'applicazione pu� essere verificata usando lo script `run-curl-client.sh` oppure `run-curl-client-forever.sh` (alla fine va arrestato con **CTRL-C**). 

Alla fine, l'applicazione pu� essere arrestata usando lo script `kill-java-processes.sh` (**da usare con cautela, perch� fa il `pkill` di tutti i processi Java in esecuzione**). 

