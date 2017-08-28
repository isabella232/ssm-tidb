
import com.sun.jna.*;

public class TidbServer{
    //define an interface and declare the func with the same name as that exported by main.go
    public interface Tidb extends Library{
        void startServer(String cmdArgs);
    }


    public static void main(String []args){

        Tidb tidb= Native.loadLibrary("./libtidb.so",Tidb.class);

        //args=new String[]{"-P","1000","--port","999"};   --used for longOpt, -used for opt
        //args=new String[]{"-P","1000"};
        StringBuffer strbuffer=new StringBuffer();
        for(String x:args){
            strbuffer.append(x);
            strbuffer.append(" ");
        }

        System.out.println("starting TiDB..");
        tidb.startServer(strbuffer.toString());






    }

}