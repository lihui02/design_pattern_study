package com.lihui.study.aop;

import com.lihui.study.aop.service.KtvServcie;
import com.lihui.study.aop.service.KtvServiceImpl;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-12-10  15:34
 */

public class Demo01 {
    public static void main(String[] args) {
        AopContainer container=new AopContainer();
        container.addBean("ktvService", KtvServiceImpl.class);
        try {
            KtvServcie ktvService = (KtvServcie)container.getBean("ktvService");
            ktvService.sing();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
