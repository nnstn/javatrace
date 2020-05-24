package com.nuoya.pattern.strategy.pay.payport;

public class UnionPay extends Payment {

    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    public Double queryBalance(String uid) {
        return 200.00;
    }
}
