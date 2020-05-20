package com.nuoya.pattern.singleton.lazy;

// 全程没有用到synchronized
// 性能最优的写法
// 作业：debug
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {}
    // 懒汉式单例
    // LazyHolder里面逻辑需要等到外部方法调用才执行
    // 巧妙利用了内部类的特性
    // JVM底层执行逻辑，完美避免了线程安全问题
    private static LazyInnerClassSingleton getInstance(){
        return LazyHolder.lazy;
    }
    private static class LazyHolder{
        private static LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }
}
