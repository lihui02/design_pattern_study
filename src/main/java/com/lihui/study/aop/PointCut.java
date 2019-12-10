package com.lihui.study.aop;

/**
 * @ClassName: PointCut
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-12-10  15:30
 */

public class PointCut {
    private String classPattern;
    private String methodPattern;

    public String getClassPattern() {
        return classPattern;
    }

    public void setClassPattern(String classPattern) {
        this.classPattern = classPattern;
    }

    public String getMethodPattern() {
        return methodPattern;
    }

    public void setMethodPattern(String methodPattern) {
        this.methodPattern = methodPattern;
    }
}
