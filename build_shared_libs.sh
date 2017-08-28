rootpath=`pwd`
buildpath=$rootpath/components/src/github.com/pingcap

cd $buildpath/pd
echo "building pd.."
make
cp libpd.so $rootpath/launch
make clean

cd $buildpath/callkv
echo "building tikv.."
cargo build
cp target/debug/libtikv.so $rootpath/launch
cargo clean

cd $buildpath/tidb
echo "building tidb.."
export GOPATH=$rootpath/components
make
cp libtidb.so $rootpath/launch
make clean

