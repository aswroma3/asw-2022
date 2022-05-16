#!/bin/bash

# esegue l'applicazione contenitorizzata  
# prerequisito: (1) build del progetto Java
# prerequisito: (2) crea l'immagine docker
#   oppure 
# prerequisito: (3) salva l'immagine su docker hub  

docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word
# docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word -jar -Dspring.profiles.active=italian lucky-word.jar
# docker container run -d -p 8080:8080 --name=lucky-word aswroma3/lucky-word -jar -Dspring.profiles.active=english lucky-word.jar



