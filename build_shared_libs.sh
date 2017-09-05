rootpath=`pwd`
buildpath=$rootpath/components/src/github.com/pingcap

cd $buildpath/pd
echo "Building pd.."
make
mv libpd.so $rootpath/launch
rm libpd.h
make clean

cd $buildpath/callkv
echo "Building tikv.."
cargo build
mv target/debug/libtikv.so $rootpath/launch
cargo clean

cd $buildpath/tidb
echo "Building tidb.."
export GOPATH=$rootpath/components
make
mv libtidb.so $rootpath/launch
rm libtidb.h 
make clean

cd $rootpath
jar cf libtidb.jar ./launch/*.so

echo "Build is completed!"
