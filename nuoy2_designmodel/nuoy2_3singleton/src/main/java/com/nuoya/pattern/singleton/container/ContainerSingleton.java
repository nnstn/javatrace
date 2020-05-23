package com.nuoya.pattern.singleton.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring 容器使用的容器方式单例模式
 */
public class ContainerSingleton {

    private ContainerSingleton() {  }

    private static Map ioc = new ConcurrentHashMap();

    public static Object getBean(String className){
        synchronized (ioc){
            if(ioc.get("className")==null){
                try {
                    Object obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                    return obj;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return ioc.get("className");
    }
}
