package com.example.design;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-23
 */

/*
* 使用单例模式的懒汉式
* */
public class SingleLazy {

    // 声明不创建实例，在第一次调用的时候创建
    private static SingleLazy singleLazy = null;

    // 构造方法私有化，防止外部创建
    public SingleLazy() {

    }

    // 提供外部访问该实例的方法，只有在第一次访问时间创建，之后直接获取
    public SingleLazy getSingleLazy() {
        if (singleLazy == null) {
            singleLazy = new SingleLazy();
        }
        return singleLazy;
    }

}
