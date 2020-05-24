package com.nuoya.pattern.strategy.promotion;

public class CouponStrategy implements IPromotionActivity {
    @Override
    public void execute() {
        System.out.println("优惠券活动");
    }
}
