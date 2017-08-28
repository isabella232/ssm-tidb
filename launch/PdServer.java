import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by philo on 17-7-31.
 */

public class PdServer {
    public interface Pd extends Library{
       void startServer(String cmdArgs);
    }
    public static void main(String []args){
        Pd pd= Native.loadLibrary("libpd.so",Pd.class);
        StringBuffer strbuffer=new StringBuffer();
        for(String x:args){
            strbuffer.append(x);
            strbuffer.append(" ");
        }

        System.out.println("starting PD..");
        pd.startServer(strbuffer.toString());
    }

}
