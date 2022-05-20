#!/bin/bash

# trova tutti gli enigmi 

echo "# trova tutti gli enigmi" 
echo $(curl -s localhost:8080/enigmi/enigmi)
echo 

