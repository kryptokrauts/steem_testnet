# TODO

> Build docker image

sudo docker build -t kk_testnet .

> Run the image
>> the mounted folder kryptokrauts/keys will contain the keys for the created user (see dockerfile)

sudo docker rm kk_testnet_v01
sudo docker run -v ~/kryptokrauts/keys:/testnet/keys --name "kk_testnet_v01"  kk_testnet
