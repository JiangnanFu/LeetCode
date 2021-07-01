package Muti_Thread;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.lang.invoke.CallSite;

/**
 @author fujiangnan
 @create 2021-03-13-11-31
 @desc 两个线程交替打印100
 */
public class Solution1 {
    public static void main(String[] args) {
        // 只有一个Task对象
        Task task = new Task();
        Thread t1 = new Thread(task, "线程1");
        Thread t2 = new Thread(task, "线程2");
        t1.start();
        t2.start();
    }
}

class Task implements Runnable {
    int i = 1;
    @Override
    public void run() {
        while(true) {
            /*指代的为Task,因为使用的是implements方式。若使用继承Thread类的方式，慎用this*/
            synchronized (this) {
                /*唤醒另外一个线程，注意是this的方法，而不是Thread*/
                notify();
                try {
                    /*使其休眠100毫秒，放大线程差异*/
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    ++i;
                    try {
                        // 放弃资源，等待唤醒
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}