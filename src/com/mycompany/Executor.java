package com.mycompany;

/**
 * Created by aznable on 2016/5/15.
 */

import java.util.concurrent.RunnableFuture;
import java.util.logging.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Executor {

    private Logger _logger;
    private final int threadNum;
    private final ExecutorService pool;

    public Executor() {
        _logger = Logger.getLogger(this.getClass().getName());
        threadNum=10;
        pool=Executors.newFixedThreadPool(30);
        for(int i=0;i<threadNum;++i){
            Runnable test=new testRun();
            pool.execute(test);
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        Executor service = new Executor();

    }
}

class testRun implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long id = Thread.currentThread().getId();
        System.out.println(name + "'s id is" + id);
    }
}
