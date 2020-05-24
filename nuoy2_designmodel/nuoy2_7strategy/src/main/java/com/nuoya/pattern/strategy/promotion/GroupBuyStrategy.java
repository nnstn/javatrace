package com.nuoya.pattern.strategy.promotion;

public class GroupBuyStrategy implements IPromotionActivity {
    @Override
    public void execute() {
        System.out.println("团购优惠策略");
    }
}
