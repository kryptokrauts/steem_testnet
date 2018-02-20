#!/bin/bash

STEEMD="/steem/build/programs/steemd"

if [[ ! -z "$STEEMD_WITNESS_NAME" ]]; then
    ARGS+=" --witness=\"$STEEMD_WITNESS_NAME\""
fi

if [[ ! -z "$STEEMD_MINER_NAME" ]]; then
    ARGS+=" --miner=[\"$STEEMD_MINER_NAME\",\"$STEEMD_PRIVATE_KEY\"]"
    ARGS+=" --mining-threads=$(nproc)"
fi

if [[ ! -z "$STEEMD_PRIVATE_KEY" ]]; then
    ARGS+=" --private-key=$STEEMD_PRIVATE_KEY"
fi

if [[ ! -z "$TRACK_ACCOUNT" ]]; then
    if [[ ! "$USE_WAY_TOO_MUCH_RAM" ]]; then
        ARGS+=" --enable-plugin=account_history"
    fi
    ARGS+=" --track-account-range=[\"$TRACK_ACCOUNT\",\"$TRACK_ACCOUNT\"]"
fi

NOW=`date +%s`
STEEMD_FEED_START_TIME=`expr $NOW - 1209600`

ARGS+=" --follow-start-feeds=$STEEMD_FEED_START_TIME"

### TODO ###
# overwrite local config with image one

#  cp /etc/steemd/config.ini $HOME/config.ini


# slow down restart loop if flapping
sleep 1


    exec chpst \
        $STEEMD \            
            --data-dir=$HOME \
            $ARGS \
            $STEEMD_EXTRA_OPTS \
            2>&1

