package thread;

import java.util.concurrent.TimeUnit;

public class ThreadLocal2 {

//    static ThreadLocal<Person> tl = new ThreadLocal<>();
    volatile static Person p = new Person();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            tl.set(new Person());
            p.name = "happy";
            System.out.println(p.name);
        }).start();

    }


}
