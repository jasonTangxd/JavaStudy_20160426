package com.xiaoxiaomo.thread;

/**
 * 优先级
 * Created by xiaoxiaomo on 2012/3/28.
 */
public class Priority {


    public static void main(String[] args) {


        new Priority().test();

    }

    private void test() {


        Thread thread=new Thread(new Test());
        thread.setName("old");
        thread.setPriority(4);//默认优先级为5


        Thread threadnew=new Thread(new Test());
        threadnew.setName("new");
        //设置优先级
        threadnew.setPriority(10);
        //获取优先级
        System.out.println(threadnew.getPriority());

        thread.start();
        threadnew.start();

    }


    /**
     * 多线程
     */
    class Test implements Runnable{


        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName());
        }
    }
}
