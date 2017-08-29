rootpath=`pwd`
buildpath=$rootpath/components/src/github.com/pingcap

cd $buildpath/pd
echo "building pd.."
make
mv libpd.so $rootpath/launch
rm libpd.h
make clean

cd $buildpath/callkv
echo "building tikv.."
cargo build
mv target/debug/libtikv.so $rootpath/launch
cargo clean

cd $buildpath/tidb
echo "building tidb.."
export GOPATH=$rootpath/components
make
mv libtidb.so $rootpath/launch
rm libtidb.h 
make clean

