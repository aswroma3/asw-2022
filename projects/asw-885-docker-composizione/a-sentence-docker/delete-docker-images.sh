#!/bin/bash

docker image rm $(docker image ls | grep sentence | grep -v compose | awk '{print $3}')




