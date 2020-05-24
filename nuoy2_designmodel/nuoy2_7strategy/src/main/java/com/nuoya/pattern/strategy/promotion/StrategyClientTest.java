package com.nuoya.pattern.strategy.promotion;

public class StrategyClientTest {
    public static void main(String[] args) {
        String promotion = "GROUPBUY";
        IPromotionActivity activity = PromotionStrategyFactory.getPromotion(promotion);
        activity.execute();
    }
}
