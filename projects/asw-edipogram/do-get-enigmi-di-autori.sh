#!/bin/bash

# trova tutti gli enigmi di un insieme di autori  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: autori-separati-da-virgola"
	exit 1 
fi

# gli autori devono essere separati da virgola 
# se un autore contiene spazi deve essere racchiuso tra virgolette 
AUTORI=$(echo $1 | sed -e "s/ /%20/g" | sed -e "s/,/%2C/g") 

echo "# tutti gli enigmi degli autori $1" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/autori/$AUTORI)
echo 

