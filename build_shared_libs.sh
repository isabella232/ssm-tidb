rootpath=`pwd`
buildpath=$rootpath/components/src/github.com/pingcap

cd $buildpath/pd
echo "Building pd.."
make
mv libpd.so $rootpath/lib
rm libpd.h
make clean

cd $buildpath/tikv
echo "Building tikv.."
cargo build
mv target/debug/libtikv.so $rootpath/lib
cargo clean

cd $buildpath/tidb
echo "Building tidb.."
export GOPATH=$rootpath/components
make
mv libtidb.so $rootpath/lib
rm libtidb.h 
make clean

cd $rootpath/lib
jar cf ../libtidb.jar *.so

echo "Build is completed!"
