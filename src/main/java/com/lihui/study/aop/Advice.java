package com.lihui.study.aop;

import java.lang.reflect.Method;

/**
 * @ClassName: Aspect
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-12-10  15:27
 */

public interface Advice {
    Object invoke(Object target, Method method,Object[] args);
}
