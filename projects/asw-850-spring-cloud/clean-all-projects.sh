#!/bin/bash

# Script per effettuare la pulizia di un insieme di progetti Gradle 

echo Cleaning all projects  

# determina il path relativo in cui si trova lo script 
# (rispetto alla posizione da cui � stata richiesta l'esecuzione dello script) 
PATH_TO_SCRIPT=`dirname $0`

# determina i progetti da costruire 
PROJECTS=$(ls ${PATH_TO_SCRIPT}/*/build.gradle)

# pulisce tutti i progetti 
for project in ${PROJECTS}; do 
	echo ""
	echo "Now cleaning ${project}"
	gradle --build-file ${project} clean
done 
