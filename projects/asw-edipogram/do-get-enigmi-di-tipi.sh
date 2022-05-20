#!/bin/bash

# trova tutti gli enigmi di un insieme di tipi  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: tipi-separati-da-virgola"
	exit 1 
fi

# i tipi devono essere separati da virgola 
# se un tipo contiene spazi deve essere racchiuso tra virgolette 
TIPI=$(echo $1 | sed -e "s/ /%20/g" | sed -e "s/,/%2C/g") 

echo "# tutti gli enigmi dei tipi $1" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/tipi/$TIPI)
echo 

