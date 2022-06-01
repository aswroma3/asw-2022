#!/bin/bash

# accede al servizio tramite ingress - ovvero, tramite il nome del servizio (sulla porta 80 o, nel caso di kube-cluster, 31080)
# DEVE ESSERE INSTALLATO UN INGRESS CONTROLLER COME ADD-ON  
# IL NOME DEL SERVIZIO DEVE ESSERE UN ALIAS DEI NOMI DEL CLUSTER - CONFIGURATO NEL DNS OPPURE IN /ETC/HOSTS 

SERVICE=hello
SERVICE_HOST=hello
# SERVICE_HOST=hello.default.svc.cluster.local
SERVICE_PORT=31080
# SERVICE_PORT=80

echo Accessing ${SERVICE} on ${SERVICE_HOST}:${SERVICE_PORT}

while true; do 
	curl ${SERVICE_HOST}:${SERVICE_PORT}
#	curl ${SERVICE_HOST}
	echo "" ; 
done 

