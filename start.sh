rootpath=`pwd`

unset http_proxy
unset https_proxy

export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$rootpath/lib

java -cp :$rootpath/lib/jna-4.4.0.jar:classes Main
