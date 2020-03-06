package com.lihui.study.aop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: AopContainer
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-12-10  15:37
 */

public class AopContainer {
    private Map<String,Class<?>> map=new HashMap<>();
    public Object getBean(String benaName) throws IllegalAccessException, InstantiationException {
        return map.get(benaName).newInstance();
    }
    public void addBean(String beanName,Class<?> clazz){
        map.put(beanName,clazz);
    }
}
