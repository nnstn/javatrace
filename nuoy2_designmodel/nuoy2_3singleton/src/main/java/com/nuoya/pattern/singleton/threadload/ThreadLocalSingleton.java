package com.nuoya.pattern.singleton.threadload;

/**
 * 注册时单例:线程内实现单例
 * 应用场景:ORM时候
 * 实现多数据源动态切换
 * spring源码时候，手写ORM实现数据源动态切换
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadlocal = new ThreadLocal<ThreadLocalSingleton>(){

        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    public ThreadLocalSingleton getInstance(){
        return threadlocal.get();
    }
}
