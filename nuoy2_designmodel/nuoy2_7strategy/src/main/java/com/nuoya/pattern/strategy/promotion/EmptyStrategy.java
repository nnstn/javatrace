package com.nuoya.pattern.strategy.promotion;

public class EmptyStrategy implements IPromotionActivity {
    @Override
    public void execute() {
        System.out.println("没有优惠活动");
    }
}
