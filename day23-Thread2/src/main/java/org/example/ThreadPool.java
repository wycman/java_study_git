package org.example;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor MyThreadPool = new ThreadPoolExecutor(
                3,
                5,
                20,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        MyThreadPool.submit(new FutureTask<Integer>(
                new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println(Thread.currentThread().getName());
                        return 1;
                    }
                }
                )
        );
    }
}
