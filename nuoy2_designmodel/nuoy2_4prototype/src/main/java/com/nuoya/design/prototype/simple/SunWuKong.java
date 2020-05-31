package com.nuoya.design.prototype.simple;

import lombok.Data;

import java.io.*;

/**
 * @author wangjn_bj 2020/5/27
 */
@Data
public class SunWuKong implements Cloneable, Serializable {

    private String range;

    private JingGuBang jingGuBang;



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    private Object deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bis);
            return  objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
