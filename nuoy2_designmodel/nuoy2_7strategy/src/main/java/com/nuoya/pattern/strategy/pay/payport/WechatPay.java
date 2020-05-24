package com.nuoya.pattern.strategy.pay.payport;

public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    public Double queryBalance(String uid) {
        return 500.00;
    }
}
