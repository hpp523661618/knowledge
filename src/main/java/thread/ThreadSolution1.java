package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法add、size,写两个线程
 * 线程1：添加10个元素到容器中
 * 线程2，实时监控元素个数，当个数到5时，线程2给出提示并结束
 */
public class ThreadSolution1 {

    volatile List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadSolution1 c = new ThreadSolution1();

        final Object lock = new Object();

        new Thread(() -> {

            synchronized (lock) {
                System.out.println("thread2 - start");
                if (c.size() != 5) {
                    try {
                        lock.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("thread2 - end");
                lock.notify();
            }
        }, "thread-2").start();

        Thread.sleep(1000);

        new Thread(() -> {

            synchronized (lock) {
                System.out.println("thread1 - start");

                for (int i = 0; i < 10; i++) {
                    c.add(i);
                    System.out.println("i = " + i);
                    try {
                        if (c.size() == 5) {
                            System.out.println("***");
                            lock.notify();
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("thread1 - end");
        }, "thread-1").start();
    }

}
