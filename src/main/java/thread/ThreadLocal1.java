package thread;

import java.util.concurrent.TimeUnit;

public class ThreadLocal1 {

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread-2 " + tl.get());
            tl.set(new Person());
        }, "thread 2").start();
    }
}

class Person {
    String name = "zhangsan";
}