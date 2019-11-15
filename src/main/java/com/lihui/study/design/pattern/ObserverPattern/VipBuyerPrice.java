package com.lihui.study.design.pattern.ObserverPattern;

/**
 * @ClassName: VipBuyerPrice
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-14  11:47
 */

public class VipBuyerPrice implements BuyerPrice {
    public double getPrice(double price) {
        return price * 0.7;
    }
}
