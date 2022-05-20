#!/bin/bash

# trova un enigma 

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: id-enigma"
	exit 1 
fi

ENIGMA=$1 

echo "# trova l'enigma $ENIGMA" 
echo $(curl -s localhost:8080/enigmi/enigmi/${ENIGMA})
echo 

echo "# trova la soluzione l'enigma $ENIGMA" 
echo $(curl -s localhost:8080/enigmi/enigmi/${ENIGMA}/soluzione)
echo 
