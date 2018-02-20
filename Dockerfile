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

# rpc service:
EXPOSE 9876
# p2p service:
EXPOSE 2001

RUN \
	mkdir /testnet
ADD config.ini /testnet/config.ini
#RUN chmod +x /usr/local/bin/steemd.sh
CMD /steem/build/programs/steemd/steemd -d testnet --enable-stale-production

