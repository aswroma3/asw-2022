#!/bin/bash

# (3) salva l'immagine su docker hub 
# prerequisito: (1) build del progetto Java
# prerequisito: (2) crea l'immagine docker 
# prerequisito: aver eseguito il docker login su docker hub 

DOCKERHUB_USERNAME=aswroma3 
IMAGE_NAME=lucky-word
VERSION=2022

docker image tag ${DOCKERHUB_USERNAME}/${IMAGE_NAME} ${DOCKERHUB_USERNAME}/${IMAGE_NAME}:${VERSION} 
docker image tag ${DOCKERHUB_USERNAME}/${IMAGE_NAME} ${DOCKERHUB_USERNAME}/${IMAGE_NAME}:latest 
docker image push ${DOCKERHUB_USERNAME}/${IMAGE_NAME}:${VERSION}
docker image push ${DOCKERHUB_USERNAME}/${IMAGE_NAME}:latest
