package com.lihui.study.design.pattern.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo01 {
    public static void main(String[] args) {
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}
