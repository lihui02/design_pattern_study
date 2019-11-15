package com.lihui.study.design.pattern.ObserverPattern;

/**
 * @ClassName: BuyPriceContext
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-14  11:59
 */

public class BuyPriceContext {
    private BuyerPrice buyerPrice;
    public BuyPriceContext(BuyerPrice buyerPrice){
        this.buyerPrice=buyerPrice;
    }
    double getPrice(double price){
        return buyerPrice.getPrice(price);
    }
}
