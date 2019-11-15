package com.lihui.study.design.pattern.ObserverPattern;

import com.lihui.study.design.pattern.Order;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: OrderListener
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-14  9:25
 */
@Component
public class MessageOrderListener implements ApplicationListener<OrderAddEvent> {
    public void onApplicationEvent(OrderAddEvent orderEvent) {
        Order order = (Order) orderEvent.getSource();
        System.out.println("发送短信,用户:"+order.getUsername()+"你的订单编号为:"+order.getCode()+"价格"+order.getPrice());

    }
}
