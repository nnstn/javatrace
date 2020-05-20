package com.nuoya.pattern.singleton.lazy;

public class LazyDoubleCheckSingleton {
    private static volatile LazyDoubleCheckSingleton lazy;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance(){
        if(null==lazy){
            synchronized (LazyDoubleCheckSingleton.class){
                if(null==lazy){
                    lazy = new LazyDoubleCheckSingleton();
                    // CPU执行时会转换成为JVM指令执行
                    // 指令重排序问题 volitile 在分布式时详解
                    // 1.分配内存给对象
                    // 2.初始化对象
                    // 3.将初始化好的对象和内存地址建立关联，赋值
                    // 4.用户初次访问
                    // 其中2,3步可能指令重排
                }
            }
        }
        return lazy;
    }
}
