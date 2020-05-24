package com.nuoya.pattern.strategy.pay;


import com.nuoya.pattern.strategy.pay.payport.PayStrategy;

public class PayStrategyTest {

    public static void main(String[] args) {

        //省略把商品添加到购物车，再从购物车下单
        //直接从点单开始
        Order order = new Order("1", "20180311001000009", 324.45);

        //这个值是在支付的时候才决定用哪个值
        System.out.println(order.pay(PayStrategy.UNION_PAY));
    }
}
