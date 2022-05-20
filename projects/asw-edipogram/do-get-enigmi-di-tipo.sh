#!/bin/bash

# trova tutti gli enigmi di un certo tipo  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: tipo"
	exit 1 
fi

# se un tipo contiene spazi deve essere racchiuso tra virgolette 
TIPO=$(echo $1 | sed -e "s/ /%20/g") 

echo "# tutti gli enigmi di tipo $1" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/tipo/$TIPO)
echo 
