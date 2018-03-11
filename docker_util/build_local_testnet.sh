#/bin/bash

sudo docker stop kk_testnet_v01

sudo docker rm kk_testnet_v01

sudo docker build -t kk_testnet ../docker
