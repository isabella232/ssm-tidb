rootpath=`pwd`

mkdir classes
cd $rootpath/threads
javac -cp :$rootpath/lib/jna-4.4.0.jar -d ../classes Main.java

echo "Finished!" 
