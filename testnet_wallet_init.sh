#!/bin/bash

#print params
if [ -z $ACCOUNT ] ; then 
	echo "no ACCOUNT param defined, exiting"
	exit -1

fi
if [ -z $WALLET_PWD ] ; then 
	echo "no WALLET_PWD param defined, exiting"
	exit -1
fi
echo "----- steem testnet parameters -----"
echo "ACCOUNT: 	"$ACCOUNT
echo "WALLET_PWD:	"$WALLET_PWD
echo "PORT: 		"$PORT
echo "----- steem testnet parameters -----"
echo ""

export ACCOUNT=$ACCOUNT
export WALLET_PWD=$WALLET_PWD

result=0
initialized=0

# connect to blockchain and check if wallet is already initialized 
# - this is the case, if the blockchain dir is mounted to a dir
log="$(/steem/build/programs/cli_wallet/cli_wallet --server-rpc-endpoint="ws://127.0.0.1:$PORT" << EOF
EOF)"
echo "log: $log"
initialized="$(echo $log | grep -c "initialize")"
if [ $initialized -lt 1 ] ; then
	echo "steem testnet not initialized, starting init script" 	
	else
	echo "steemt testnet already initialized, init script will not be started"
fi

if [ $initialized == 0 ] ; then
while [ $result -lt 1 ] ; do
        echo "trying to create wallet and account"
        sleep 10
	$SCRIPTS_DIR/testnet_config.here >> initialize_wallet.log
        result=$(grep -c 'unlocked' initialize_wallet.log)
	if [ $result -lt 1 ] ; then
		echo "steem testnet not up, waiting..."
	else	
		echo "steem testnet initialized, happy steemin' ;)"
	fi
done
fi
