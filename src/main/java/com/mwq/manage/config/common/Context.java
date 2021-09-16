package com.mwq.manage.config.common;

/**
 * 获取用户信息
 *
 * @author wq
 */
public class Context implements AutoCloseable {

    private static final ThreadLocal<Object> VALUE = new ThreadLocal<>();

    public static void set(Object token) {
        VALUE.set(token);
    }


    public static Object get() {
        return VALUE.get();
    }

    @Override
    public void close() {
        VALUE.remove();
    }

}