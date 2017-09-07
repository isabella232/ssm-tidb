/**
 * Created by philo on 17-9-7.
 */
public class Main {
  public static void main(String []args){
    Thread db=new Thread(new Launch());
    db.start();
    System.out.println("Starting database..");
  }
}
