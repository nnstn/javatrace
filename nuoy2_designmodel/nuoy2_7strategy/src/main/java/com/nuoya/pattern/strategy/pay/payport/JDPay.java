package com.nuoya.pattern.strategy.pay.payport;

public class JDPay extends Payment {

    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    public Double queryBalance(String uid) {
        return 500.00;
    }
}
