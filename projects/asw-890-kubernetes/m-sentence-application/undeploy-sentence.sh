#!/bin/bash

echo 'Halting sentence' 

kubectl delete -f sentence-application.yaml -n sentence
kubectl delete namespace sentence

