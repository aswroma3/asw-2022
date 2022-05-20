#!/bin/bash

# aggiunge nuovi enigmi 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Il Valletto\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"Ciclista sfortunato\", \"testo\": [ \"Allor che cominciò la sua avventura\", \"dal gruppo lo staccò una foratura;\", \"poi fu visto cadere perché aveva\", \"la gomma posterior che non teneva.\" ], \"soluzione\": [ \"Il francobollo\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Il Valletto\", \"tipo\": \"Cambio\", \"tipoSpecifico\": \"Cambio di vocale (6)\", \"titolo\": \"Osanna\", \"testo\": [ \"È un canto\", \"celestiale.\" ], \"soluzione\": [ \"angOlo\", \"angElo\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Dendi\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"Mia nonna\", \"testo\": [ \"È vecchia, stalle vicino.\" ], \"soluzione\": [ \"La fattoria\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Dendi\", \"tipo\": \"Cambio\", \"tipoSpecifico\": \"Cambio di iniziale (5)\", \"titolo\": \"Promessa del calcio\", \"testo\": [ \"Come attaccante\", \"mi pare scattante.\" ], \"soluzione\": [ \"Colla\", \"Molla\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Body\", \"tipo\": \"Spostamento\", \"tipoSpecifico\": \"Spostamento\", \"titolo\": \"Meraviglie della Natura\", \"testo\": [ \"Tra due spighe di yxxxx\", \"ha tessuto quel xxyxx\", \"con perizia una tela.\" ], \"soluzione\": [ \"Grano\", \"raGno\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Alcir\", \"tipo\": \"Scarto\", \"tipoSpecifico\": \"Scarto sillabico\", \"titolo\": \"Cara, il taxi aspetta!\", \"testo\": [ \"È l'unico xxxyyxxx\", \"per farle fare xxxxxx.\" ], \"soluzione\": [ \"preTEsto\", \"presto\" ] }"
echo 
