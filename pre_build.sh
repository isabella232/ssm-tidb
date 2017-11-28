#install Golang
wget https://storage.googleapis.com/golang/go1.8.3.linux-amd64.tar.gz
tar -xf go1.8.3.linux-amd64.tar.gz
mv go/ /usr/local/
rm go1.8.3.linux-amd64.tar.gz
export PATH=/usr/local/go/bin:$PATH
export GOROOT=/usr/local/go

#install Rust
wget https://static.rust-lang.org/dist/2017-08-09/rust-nightly-x86_64-unknown-linux-gnu.tar.gz
tar -xf rust-nightly-x86_64-unknown-linux-gnu.tar.gz
pushd rust-nightly-x86_64-unknown-linux-gnu && sudo ./install.sh && popd
rm -r rust-nightly-x86_64-unknown-linux-gnu.tar.gz rust-nightly-x86_64-unknown-linux-gnu

#install Rocksdb
./build_rocksdb.sh