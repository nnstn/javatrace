package com.nuoya.pattern.strategy.promotion;

public class CashbackStrategy implements IPromotionActivity {
    @Override
    public void execute() {
        System.out.println("现金返现活动");
    }
}
