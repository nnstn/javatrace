package com.nuoya.pattern.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册式单例工厂结合模式
 */
public class PromotionStrategyFactory {
    private static Map<String, IPromotionActivity> PROMOTION_MAP = new HashMap<>();

    private PromotionStrategyFactory() {
    }

    static {
        PROMOTION_MAP.put(StrategyInterface.EMPTY,new EmptyStrategy());
        PROMOTION_MAP.put(StrategyInterface.CASHBACK,new CashbackStrategy());
        PROMOTION_MAP.put(StrategyInterface.GROUPBUY,new GroupBuyStrategy());
        PROMOTION_MAP.put(StrategyInterface.COUPON,new CouponStrategy());
    }

    public static IPromotionActivity getPromotion(String promotion) {
        if(null==PROMOTION_MAP.get(promotion)){
            throw new RuntimeException("请求参数有误");
        }
        return PROMOTION_MAP.get(promotion);
    }

    private interface StrategyInterface {
        String GROUPBUY = "GROUPBUY";
        String CASHBACK = "CASHBACK";
        String COUPON = "COUPON";
        String EMPTY = "EMPTY";
    }
}
