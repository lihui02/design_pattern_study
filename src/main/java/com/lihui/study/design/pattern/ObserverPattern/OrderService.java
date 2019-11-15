package com.lihui.study.design.pattern.ObserverPattern;

import com.lihui.study.design.pattern.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: OrderService
 * @Description: 订单服务，每下订单之后都要发短信/发邮件等，为方面后续修改，采用spring自带的观察者模式。在这里发布一个事件，所有的观察者都
 * 可以监听到这个事件，做出自己的反应
 * @author: ex_lihui4
 * @date: 2019-11-14  9:22
 */
@Service
public class OrderService {
    @Resource
    private ApplicationContext applicationContext;

    /**
     * 新增订单，应用观察者模式
     */
    public void add(String userType){
        //dev分支增加的内容
        System.out.println("增加订单");
        //发布新增订单事件
        Order order=new Order();
        order.setCode("master");
        order.setUsername("lila");
       //采用策略模式获取不同用户的价格
        VipBuyerPrice vipBuyerPrice=new VipBuyerPrice();
        BuyPriceContext context=new BuyPriceContext(vipBuyerPrice);
        order.setPrice(context.getPrice(15));
        applicationContext.publishEvent(new OrderAddEvent(order));
    }

}
