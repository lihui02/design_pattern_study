package com.lihui.study.design.pattern.ObserverPattern;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName: OrderEvent
 * @Description: 订单事件，被观察者
 * @author: ex_lihui4
 * @date: 2019-11-14  9:24
 */

public class OrderAddEvent extends ApplicationEvent {
    public OrderAddEvent(Object source) {
        super(source);
    }
}
