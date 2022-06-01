#!/bin/bash

source "/home/asw/resources/common.sh"

# see https://github.com/containerd/containerd/blob/main/docs/getting-started.md 
# see https://github.com/containerd/containerd/releases
# e.g. https://github.com/containerd/containerd/releases/download/v1.6.4/containerd-1.6.4-linux-amd64.tar.gz

echo "====================="
echo "installing containerd"
echo "====================="

# let iptables see bridged traffic
# see https://kubernetes.io/docs/setup/production-environment/container-runtimes/

cat <<EOF | sudo tee /etc/modules-load.d/k8s.conf
overlay
br_netfilter
EOF

modprobe overlay
modprobe br_netfilter

# sysctl params required by setup, params persist across reboots
cat <<EOF | sudo tee /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-iptables  = 1
net.bridge.bridge-nf-call-ip6tables = 1
net.ipv4.ip_forward                 = 1
EOF

# Apply sysctl params without reboot
sudo sysctl --system

# runc 

if ! downloadExists runc.amd64 ; then
	wget -q -P ${ASW_DOWNLOADS} https://github.com/opencontainers/runc/releases/download/v1.1.2/runc.amd64
fi
install -m 755 ${ASW_DOWNLOADS}/runc.amd64 /usr/local/sbin/runc

# cni plugin 

if ! downloadExists cni-plugins-linux-amd64-v1.1.1.tgz ; then
	wget -q -P ${ASW_DOWNLOADS} https://github.com/containernetworking/plugins/releases/download/v1.1.1/cni-plugins-linux-amd64-v1.1.1.tgz
fi 

mkdir -p /opt/cni/bin
tar Cxzvf /opt/cni/bin ${ASW_DOWNLOADS}/cni-plugins-linux-amd64-v1.1.1.tgz

# containerd 

if ! downloadExists $CONTAINERD_ARCHIVE; then
	wget -q -P ${ASW_DOWNLOADS} https://github.com/containerd/containerd/releases/download/v1.6.4/containerd-1.6.4-linux-amd64.tar.gz
fi
tar Cxzvf /usr/local ${ASW_DOWNLOADS}/containerd-1.6.4-linux-amd64.tar.gz
mkdir -p /usr/local/lib/systemd/system/ 
cp ${ASW_RESOURCES}/kube-cluster/containerd.service /usr/local/lib/systemd/system/

mkdir -p /etc/containerd
cp ${ASW_RESOURCES}/kube-cluster/etc.containerd/config.toml /etc/containerd/config.toml

systemctl daemon-reload
systemctl enable --now containerd
systemctl restart containerd

# installa anche nerdctl 

# nerdctl è l'analogo del client docker per containerd 
# https://github.com/containerd/nerdctl 
# https://github.com/containerd/nerdctl/releases 
# https://github.com/containerd/nerdctl/releases/download/v0.20.0/nerdctl-0.20.0-linux-amd64.tar.gz

if ! downloadExists nerdctl-0.20.0-linux-amd64.tar.gz ; then
	wget -q -P ${ASW_DOWNLOADS} https://github.com/containerd/nerdctl/releases/download/v0.20.0/nerdctl-0.20.0-linux-amd64.tar.gz
fi
tar Cxzvvf /usr/local/bin ${ASW_DOWNLOADS}/nerdctl-0.20.0-linux-amd64.tar.gz

