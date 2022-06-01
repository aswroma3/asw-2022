#!/bin/bash

# accede al servizio tramite service nodeport - sulla porta del servizio, su uno dei nodi del cluster  
# funziona anche dall'esterno del cluster (dal nodo dev)  

SERVICE=hello-svc

SERVICE_HOST=kube-cluster
SERVICE_PORT=$(kubectl get services/${SERVICE} -o go-template='{{(index .spec.ports 0).nodePort}}')

echo Accessing ${SERVICE} on ${SERVICE_HOST}:${SERVICE_PORT}

while true; do 
	curl ${SERVICE_HOST}:${SERVICE_PORT}
	echo "" ; 
done 

