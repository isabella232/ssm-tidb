This repository mainly includes the source code of Pd, TiKV and TiDB for building shared libraries.

# Build prerequisite

You can just run pre_build.sh to install the following dependencies.

1. install Golang (1.5+ version).

   https://golang.org/dl/

   Suppose ${GO_HOME} is the path where golang is installed. Please set ${GO_HOME}/bin/ in $PATH.
   If ${GO_HOME} is not under /usr/local/, please set $GOROOT: export GOROOT=${GO_HOME}.

2. install Rust. Only the nightly version is valid.

   https://www.rust-lang.org/en-US/other-installers.html

3. build Rocksdb.

   run build_rocksdb.sh

# Support SSM project

  To enable TiDB in SSM (https://github.com/Intel-bigdata/SSM.git), you should run build_shared_libs.sh to generate three files with .so suffix under lib/ directory in this project.

  After build is completed, you should put libpd.so, libtikv.so and libtidb.so into {SSM_HOME}/lib.
  The libtikv.so is dynamically linked to librocksdb.so.5.6. So you should also build rocksdb as build prerequisite section guides on each host where TiKV is deployed.

# Run demo

  Run compile.sh to compile the java code and run start.sh to start tidb.

# Deployment tips

unset http_proxy and https_proxy.

