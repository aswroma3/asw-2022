# Sentence per Kubernetes

Questo sottoprogetto contiene il codice di specifica per rilasciare l'applicazione **sentence** su **Kubernetes**. 

## Ambiente di esecuzione 

Questa applicazione va eseguita nell'ambiente [kube-cluster](../../environments/kube-cluster/), sul nodo **dev**. 
Vanno però utilizzate più finestre (terminali) diverse. In genere, una per l'applicazione e una per il suo client.  

## Esecuzione 

Per avviare l'applicazione sul nodo **dev**, eseguire lo script `deploy-sentence.sh`. 

Complessivamente, l'applicazione *sentence* espone un servizio REST sul cluster *kube-cluster* all'indirizzo **http://sentence:31080**, da cui è possibile ottenere una frase casuale.

In pratica, l'applicazione può essere verificata usando gli script `run-curl-client-ingress.sh` e `run-curl-client-nodeport.sh`. 

## Arresto 

Per arrestare l'applicazione, eseguire lo script `undeploy-sentence.sh` 

