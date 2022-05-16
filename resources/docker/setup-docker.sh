#!/bin/bash

source "/home/asw/resources/common.sh"

# see https://docs.docker.com/engine/install/ubuntu/

# per sovrascrivere la configurazione di docker, 
# invocare uno script separato come prepare-docker-configuration.sh 

# set up Docker constants 
# DOCKER_VERSION=5:20.10.5~3-0~ubuntu-focal
# DOCKER_VERSION=5:20.10.6~3-0~ubuntu-focal
#DOCKER_VERSION=5:20.10.7~3-0~ubuntu-focal
#DOCKER_VERSION=5:20.10.14~3-0~ubuntu-focal
DOCKER_VERSION=5:20.10.16~3-0~ubuntu-focal

# Per vedere le versioni disponibili 
# apt-cache madison docker-ce
# oppure https://download.docker.com/linux/ubuntu/dists/focal/pool/stable/amd64/ 
# vedi anche https://github.com/docker/docker-ce/releases 

echo "================="
echo "installing docker"
echo "================="

# per Ubuntu 20.04 LTS 
VAGRANT_USER=vagrant 

# Update the apt package index 
apt-get update 

# Install packages to allow apt to use a repository over HTTPS:
apt-get -y install \
#     apt-transport-https \
    ca-certificates \
    curl \
	gnupg \
    lsb-release

# Add Docker’s official GPG key: 
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

# Set up the stable repository
#echo \
#  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
#  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# Update (again) the apt package index 
apt-get update 

# Install the latest version of Docker CE 
# sudo apt-get install docker-ce docker-ce-cli containerd.io

# Per vedere le versioni disponibili 
# apt-cache madison docker-ce

# Per installare una versione specifica (raccomandato in produzione) 
apt-get -y install docker-ce=${DOCKER_VERSION} docker-ce-cli=${DOCKER_VERSION} containerd.io docker-compose-plugin

# Alcuni esempi per verificare l'installazione 
# docker run hello-world
# docker run docker/whalesay cowsay Hello, world! 
# docker run -it ubuntu bash

##### post-installation 

# non serve: groupadd: group 'docker' already exists
# groupadd docker

# abilita l'utente vagrant 
usermod -aG docker ${VAGRANT_USER}
# Remember to log out and back in for this to take effect! oppure 
newgrp docker

##### configure docker to start on boot 

### Su Ubuntu 16.04 e superiori 
systemctl enable docker.service
systemctl enable containerd.service
systemctl daemon-reload
systemctl restart docker.service

### Su Ubuntu 14.04 viene avviato di default 
