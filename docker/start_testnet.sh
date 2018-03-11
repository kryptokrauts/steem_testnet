#!/bin/bash

#start daemon process which creates the given account
$SCRIPTS_DIR/testnet_wallet_init.sh > init.log &
echo "keys dir $KEYS_DIR"
echo Starting Steem Testnet
/steem/build/programs/steemd/steemd -d testnet --enable-stale-production 

