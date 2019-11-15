package com.lihui.study.design.pattern;

import com.lihui.study.design.pattern.ObserverPattern.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: OrderServiceTest
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-14  9:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Resource
    private OrderService orderService;
    @Test
    public void addTest(){
        orderService.add("svip");
    }
}
