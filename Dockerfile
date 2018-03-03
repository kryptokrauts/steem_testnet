FROM phusion/baseimage:0.9.19

ENV LANG=en_US.UTF-8

RUN \
  apt-get update && \
  apt-get install -y \
    autoconf \
    automake \
    cmake \
    g++ \
    git \
    libssl-dev \
    libtool \
    make \
    pkg-config \
    python3 \
    python3-jinja2 \
    libboost-chrono-dev \
    libboost-context-dev \
    libboost-coroutine-dev \
    libboost-date-time-dev \
    libboost-filesystem-dev \
    libboost-iostreams-dev \
    libboost-locale-dev \
    libboost-program-options-dev \
    libboost-serialization-dev \
    libboost-signals-dev \
    libboost-system-dev \
    libboost-test-dev \
    libboost-thread-dev \
    doxygen \
    libncurses5-dev \
    libreadline-dev \
    perl

RUN \
    
    git clone https://github.com/steemit/steem && \
    cd steem && \
    git checkout tags/v0.19.2 && \ 
    git submodule update --init --recursive && \
    mkdir build && \
    cd build && \
    cmake \
        -DBUILD_STEEM_TESTNET=ON \        
        ..

RUN \
    cd steem/build/ &&\
    make -j$(nproc) steemd &&\
    make -j$(nproc) cli_wallet


RUN \
 apt-get remove -y \
    autoconf \
    automake \
    cmake \
    g++ \
    git \
    libssl-dev \
    libtool \
    make \
    pkg-config \
    python3 \
    python3-jinja2 \
    libboost-chrono-dev \
    libboost-context-dev \
    libboost-coroutine-dev \
    libboost-date-time-dev \
    libboost-filesystem-dev \
    libboost-iostreams-dev \
    libboost-locale-dev \
    libboost-program-options-dev \
    libboost-serialization-dev \
    libboost-signals-dev \
    libboost-system-dev \
    libboost-test-dev \
    libboost-thread-dev \
    doxygen \
    libncurses5-dev \
    libreadline-dev \
    perl

# config 
ENV TESTNET_DIR=/testnet
ENV SCRIPTS_DIR=/scripts

#wallet password
ENV WALLET_PWD=kryptokrauts
# inital account
ENV ACCOUNT=krautfather

# rpc service:
ENV PORT=9876
EXPOSE $PORT
# p2p service:
EXPOSE 2001

RUN \
	mkdir $TESTNET_DIR

RUN \
	mkdir $SCRIPTS_DIR

ADD config.ini $TESTNET_DIR/config.ini
ADD testnet_config.here $SCRIPTS_DIR/testnet_config.here
ADD testnet_wallet_init.sh $SCRIPTS_DIR/testnet_wallet_init.sh
ADD start_testnet.sh $SCRIPTS_DIR/start_testnet.sh 

CMD $SCRIPTS_DIR/start_testnet.sh 

