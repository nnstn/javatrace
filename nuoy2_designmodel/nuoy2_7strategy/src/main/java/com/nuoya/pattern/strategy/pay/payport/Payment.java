package com.nuoya.pattern.strategy.pay.payport;


import com.nuoya.pattern.strategy.pay.PayState;

/**
 * 支付渠道
 * Created by Tom on 2018/3/11.
 */
public abstract class Payment {

    public abstract String getName();
    public abstract Double queryBalance(String uid);

    public PayState pay(String uid, Double amount){
        if (amount.compareTo(queryBalance(uid))>0){
            return new PayState(500,"支付失败","余额不足");
        }

        return new PayState(500,"支付成功","支付金额:"+amount);
    }

}
