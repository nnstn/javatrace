package com.nuoya.pattern.strategy.pay.payport;



/**
 * Created by Tom on 2018/3/11.
 */
public class AliPay extends Payment {

    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    public Double queryBalance(String uid) {
        return 500.00;
    }
}
