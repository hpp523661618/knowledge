package thread;

import java.util.LinkedList;

/**
 * 写一个固定容量同步容器(消息队列)，拥有put和get方法，以及getCount方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
public class ThreadSolution2<T> {

    private LinkedList<T> list = new LinkedList<>();
    private int MAX_COUNT = 10;
    private int count = 0;

    //生产者
    public synchronized void put(T val) {
        while (list.size() == MAX_COUNT) {
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(val);
        ++count;
        this.notifyAll();
    }

    //消费者
    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count --;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {

        ThreadSolution2<String> c = new ThreadSolution2<>();
        //消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(c.get());
                }
            }, "consumer " + i).start();
        }

        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产者
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "producer " + i).start();
        }
    }

}
