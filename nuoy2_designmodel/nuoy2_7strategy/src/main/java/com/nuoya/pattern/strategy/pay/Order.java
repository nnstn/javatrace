package com.nuoya.pattern.strategy.pay;

import com.nuoya.pattern.strategy.pay.payport.PayStrategy;
import com.nuoya.pattern.strategy.pay.payport.Payment;

public class Order {

    private String uid;
    private String orderid;
    private Double amount;

    public Order(String uid, String orderid, Double amount) {
        this.uid = uid;
        this.orderid = orderid;
        this.amount = amount;
    }

    //完美地解决了switch的过程，不需要在代码逻辑中写switch了
    //更不需要写if    else if
    public PayState pay(String payKey){
        Payment payment = PayStrategy.getPayMent(payKey);
        System.out.println("欢迎使用："+payment.getName());
        System.out.println("本次交易金额为："+amount+",开始付款。。。");

        return payment.pay(uid,amount);
    }
}
