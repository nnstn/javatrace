package com.nuoya.pattern.singleton.lazy;

import java.io.Serializable;

// 全程没有用到synchronized
// 性能最优的写法
// 作业：debug
public class LazyInnerClassSingleton implements Serializable {

    private LazyInnerClassSingleton() {
        System.out.println("=============");
        //避免反射创建多个实例。使用反射创建多个实例后在创建会报错
        if(LazyHolder.lazy!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    // 懒汉式单例
    // LazyHolder里面逻辑需要等到外部方法调用才执行
    // 巧妙利用了内部类的特性
    // JVM底层执行逻辑，完美避免了线程安全问题
    public static LazyInnerClassSingleton getInstance(){
        return LazyHolder.lazy;
    }
    private static class LazyHolder{
        private static LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }

    /**
     * 重写readResolve方法,只不过是覆盖了反序列化出来的对象
     * 还是创建了两次，发生在JVM层面，相对来说比较安全
     * 之前反序列化出来的对象会被GC回收
     */
    private Object readResolve(){
        return LazyHolder.lazy;
    }
}
