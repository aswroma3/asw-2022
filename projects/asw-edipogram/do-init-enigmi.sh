#!/bin/bash

# inizializza il db degli enigmi 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Azimut\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"Un'esecuzione ben riuscita\", \"testo\": [ \"Quell'andante in sol maggiore\", \"con scioltezza terminò!\" ], \"soluzione\": [ \"Icaro\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Turandot\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"Il Corriere della Sera\", \"testo\": [ \"È un noto quotidian di gran formato.\" ], \"soluzione\": [ \"Il pane\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Il Mancino\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"La nonna\", \"testo\": [ \"Lavora d'ago fino a mezzanotte\", \"per aggiustare le mutande rotte.\" ], \"soluzione\": [ \"La bussola\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Il Valletto\", \"tipo\": \"Indovinello\", \"tipoSpecifico\": \"Indovinello\", \"titolo\": \"Il mese di maggio\", \"testo\": [ \"Ratto trascorre\", \"e a noi rose dispensa.\" ], \"soluzione\": [ \"Il topo\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Radar\", \"tipo\": \"Cambio\", \"tipoSpecifico\": \"Cambio di consonante (7)\", \"titolo\": \"Turisti contro la crisi\", \"testo\": [ \"Han preso piede e poi, per certi versi,\", \"s'intonano davvero con quest'aria\", \"ché in effetti al momento del bisogno\", \"è la calata loro necessaria.\" ], \"soluzione\": [ \"caNzoni\", \"caLzoni\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Il Valletto\", \"tipo\": \"Cambio\", \"tipoSpecifico\": \"Cambio di vocale (7)\", \"titolo\": \"Ponte pericolante\", \"testo\": [ \"Saldo non è...\", \"e questo può esser grave!\" ], \"soluzione\": [ \"accOnto\", \"accEnto\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Dendi\", \"tipo\": \"Cambio\", \"tipoSpecifico\": \"Cambio di finale\", \"titolo\": \"C'è molto traffico\", \"testo\": [ \"Raggiungerò Xxxx, ma non so xxxy.\" ], \"soluzione\": [ \"Como\", \"come\" ] }"
echo 

curl -X POST "http://localhost:8080/enigmi/enigmi" -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"autore\": \"Donatella\", \"tipo\": \"Anagramma\", \"tipoSpecifico\": \"Anagramma\", \"titolo\": \"Dopo pranzo\", \"testo\": [ \"Sparecchiata la xxxxxx,\", \"ho subito xxxxxx\", \"la tovaglia macchiata\", \"di vino e cioccolato.\" ], \"soluzione\": [ \"tavola\", \"lavato\" ] }"
echo 
