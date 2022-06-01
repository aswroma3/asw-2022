#!/bin/bash

# accede al servizio per una parola tramite ingress  

WORD=${1:-subject}

N=${2:-1}

# ma nell'ambiente kube-cluster, la porta per l'ingress e' 31080 (31443 per hhtps) 
INGRESS_PORT=31080

SERVICE=sentence
SERVICE_HOST=sentence

echo Accessing ${SERVICE}/${WORD} on ${SERVICE_HOST}:${INGRESS_PORT}/${WORD}

for ((i=0; i<$N; i++)); do 
	curl ${SERVICE_HOST}:${INGRESS_PORT}/${WORD}
	echo "" ; 
done 

