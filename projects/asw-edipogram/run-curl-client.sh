#!/bin/bash

# esegue un insieme di interrogazioni di esempio 

echo "# tutti gli enigmi"  
echo $(curl -s localhost:8080/enigmi/enigmi)
echo 

echo "# l'enigma 1" 
echo $(curl -s localhost:8080/enigmi/enigmi/1)
echo 

echo "# la soluzione dell'enigma 1" 
echo $(curl -s localhost:8080/enigmi/enigmi/1/soluzione)
echo 

echo "# tutti gli enigmi dell'autore Il Valletto" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/autore/Il%20Valletto)
echo 

echo "# tutti gli enigmi di tipo Indovinello" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/tipo/Indovinello)
echo 

echo "# tutti gli enigmi di tipo Cambio" 
echo $(curl -s localhost:8080/enigmi/cercaenigmi/tipo/Cambio)
echo 

echo "# tutte le connessioni" 
echo $(curl -s localhost:8080/connessioni/connessioni)
echo 

echo "# tutte le connessioni di Alice" 
echo $(curl -s localhost:8080/connessioni/connessioni/Alice)
echo 

echo "# gli enigmi seguiti da Alice" 
echo $(curl -s localhost:8080/enigmi-seguiti/enigmiseguiti/Alice)
echo 

echo "# gli enigmi seguiti da Barbara" 
echo $(curl -s localhost:8080/enigmi-seguiti/enigmiseguiti/Barbara)
echo 

echo "# gli enigmi seguiti da Carlo" 
echo $(curl -s localhost:8080/enigmi-seguiti/enigmiseguiti/Carlo)
echo 
