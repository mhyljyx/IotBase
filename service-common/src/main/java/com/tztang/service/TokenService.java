package com.tztang.service;

public abstract class TokenService<T> {

    //验证token
    public boolean verifyToken(String newToken) {
        return false;
    }

    //创建token
    public String createToken(T t) throws InstantiationException, IllegalAccessException {
        return null;
    }

    //获取基本信息
    public String getBaseInfo(String token) throws InstantiationException, IllegalAccessException {
        return null;
    }

    //刷新存活时间
    public void refresh()

}
