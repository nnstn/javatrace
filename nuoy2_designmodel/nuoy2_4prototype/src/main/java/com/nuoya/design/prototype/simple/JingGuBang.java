package com.nuoya.design.prototype.simple;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjn_bj 2020/5/27
 */
@Data
public class JingGuBang implements Cloneable, Serializable {

    private int high;
    private int wegiht;
    private String describe;


}
