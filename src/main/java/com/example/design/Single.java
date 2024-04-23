package com.example.design;

/**
 * @author chengyunbo@gyyx.cn
 * @since 2024-04-23
 */

/*
* 使用单例模式的饿汉式
* */
public class Single {


    //饿汉式：在类加载的时候创建实例
    private static final Single single = new Single();

    // 构造方法私有化，防止外部创建
    public Single() {

    }

    // 对外提供获取该实例的静态方法
    public static Single getSingle() {
        return single;
    }

}
