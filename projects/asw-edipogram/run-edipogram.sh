#!/bin/bash

# Script per avviare l'applicazione Edipogram 

echo Running EDIPOGRAM 

# Consul deve essere avviato separatamente 

java -Xms64m -Xmx128m -jar enigmi/build/libs/enigmi.jar &
java -Xms64m -Xmx128m -jar connessioni/build/libs/connessioni.jar &
java -Xms64m -Xmx128m -jar enigmi-seguiti/build/libs/enigmi-seguiti.jar &

java -Xms64m -Xmx128m -jar api-gateway/build/libs/api-gateway.jar &
