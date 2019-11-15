package com.lihui.study.design.pattern;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-11-14  10:44
 */

public class Order {
    private String username;
    private String code;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
