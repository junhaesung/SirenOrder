package com.haeseong.sirenorder.util;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<Class, Object> contextMap = new HashMap<>();

    public <T> T get(final Class<T> clazz) {
        return (T) contextMap.get(clazz);
    }

    public <T> T put(final T value) {
        return (T) contextMap.put(value.getClass(), value);
    }

}
