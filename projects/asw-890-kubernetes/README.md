# Orchestrazione di contenitori con Kubernetes (asw-890)

Questo progetto contiene alcune applicazioni che esemplificano il rilascio di applicazioni a servizi mediante l'orchestrazione di container con **Kubernetes**. 

In particolare, le applicazioni sono in genere delle varianti delle applicazioni **hello** descritta nel progetto [asw-825-spring-boot/](../asw-825-spring-boot/) e 
dell'applicazione distribuita **sentence** descritta nel progetto [asw-850-spring-cloud/](../asw-850-spring-cloud/). 

* [a-hello-kube-dockerhub](a-hello-kube-dockerhub/): codice sorgente per l'applicazione **hello** (le immagini dei container sono già disponibili su *Docker Hub*)

* [b-hello-pod](b-hello-pod/): esemplifica l'uso di uan risorsa *pod* 

* [c-hello-rs](c-hello-rs/): esemplifica l'uso di una risorsa *replica set* 

* [d-hello-deployment](d-hello-deployment/): esemplifica l'uso di una risorsa *deployment* 

* [e-hello-service-clusterip](e-hello-service-clusterip/) e [f-hello-service-nodeport](f-hello-service-nodeport/): esemplificano l'uso di risorse *service* 

* [g-hello-ingress](g-hello-ingress/): esemplifica l'uso di una risorsa *ingress* 

* [h-hello-namespace](h-hello-namespace/): esemplifica l'uso di una risorsa *namespace* 

* [i-hello-application](i-hello-application/): l'applicazione **hello** per Kubernetes completa 

* [l-sentence-kube-dockerhub](l-sentence-kube-dockerhub/): codice sorgente per l'applicazione **sentence** (le immagini dei container sono già disponibili su *Docker Hub*)

* [m-sentece-application](m-sentece-application/): l'applicazione **sentence** per Kubernetes completa 

* [p-hello-update-kube-dockerhub](p-hello-update-kube-dockerhub/): codice sorgente per tre diverse versione dell'applicazione **hello-update** (le immagini dei container sono già disponibili su *Docker Hub*)

* [q-hello-update](q-hello-update/): esemplifica l'esecuzione di rolling update con Kubernetes con riferimento all'applicazione **hello-update** 

Poiché attualmente l'ingress controller non è configurato correttamente, i progetti che utilizzano questa funzionalità funzionano solo in modo incompleto.


## Ambiente di esecuzione 

Queste applicazioni vanno eseguite nell'ambiente [kube-cluster](../../environments/kube-cluster/), sul nodo **dev**. 
(In alcuni casi preliminari o intermedi, il client può essere eseguito solo dai nodi **kube-1**, **kube-2** e **kube-3** del cluster.) 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client.  

