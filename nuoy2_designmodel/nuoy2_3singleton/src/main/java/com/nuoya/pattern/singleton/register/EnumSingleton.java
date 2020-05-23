package com.nuoya.pattern.singleton.register;

/**
 * jad.exe EnumSingleton.class
 *
 */
public enum EnumSingleton {
    instance;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return instance;
    }
}
