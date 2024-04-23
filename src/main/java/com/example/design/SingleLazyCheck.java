package com.example.design;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-23
 */
/*
* 双重检查使用也是懒汉式，为了解决在并发情况创建实例的安全性
* 在并发情况下，第一次可能进入的线程不只一个，可能多个，如果都进入了，
* 那么会创建多个实例对象，不满足单例模式了
* */
public class SingleLazyCheck {

    // 此时先声明实例对象，并不实际的创建，需要使用 volatile 关键字修饰
    // 使用 volatile 是为了保证可见性，当一个线程已经修改完之后，对其他线程立即可见的，即就已经不是null了
    private volatile static SingleLazyCheck singleLazyCheck = null;

    private final Object lock = new Object();

    // 提供构造方法，防止外部调用创建
    public SingleLazyCheck() {

    }

    // 对外提供获取该单例对象的方法
    // 这个实例化对象过程需要加锁，synchronized，为了确保只有一个线程在实例化对象，其他线程阻塞
    public SingleLazyCheck getSingleLazyCheck() {
        // 第一次检查，提高性能
        if (singleLazyCheck == null) {
            synchronized (lock) {
                // 第二次检查，防止多个线程都通过了第一次检查，它并不是所有线程同时进入 synchronized 中的哈
                // synchronized代码块中每次只有一个线程执行，加入以下判断是为了解决通过第一次检查在synchronized外阻塞的线程
                if (singleLazyCheck == null) {
                    return new SingleLazyCheck();
                }
            }
        }
        return singleLazyCheck;
    }

}
