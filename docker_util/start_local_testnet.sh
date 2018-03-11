#/bin/bash

sudo docker rm kk_testnet_v01

sudo docker run -v ~/kryptokrauts/keys:/testnet/keys --name "kk_testnet_v01"  kk_testnet
