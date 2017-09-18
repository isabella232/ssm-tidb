rootpath=`pwd`

mkdir -p classes
cd $rootpath/threads
javac -cp :$rootpath/lib/jna-4.4.0.jar -d ../classes Main.java

echo "Finished!" 
