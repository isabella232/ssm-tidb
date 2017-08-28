import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by philo on 17-8-2.
 */
public class TikvServer {
    public interface Tikv extends Library {
        void startServer(String cmd_args);
    }
    public static void main(String []args){
        Tikv kv= Native.loadLibrary("./libtikv.so",Tikv.class);
        StringBuffer strbuffer=new StringBuffer();
        strbuffer.append("TiKV");  //@ App::new("TiKV") in start.rs, "TiKV" is the command name used for parsing
        strbuffer.append(" ");
        int i=0;
        for(String x:args){
            strbuffer.append(x);
            i++;
            if(i!=args.length)
                strbuffer.append(" ");
        }
        System.out.println("starting TiKV..");


        kv.startServer(strbuffer.toString());

    }

}
