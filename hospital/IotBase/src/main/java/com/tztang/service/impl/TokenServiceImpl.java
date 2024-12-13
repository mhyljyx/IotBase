package com.tztang.service.impl;

import com.tztang.core.RedisKeyManage;
import com.tztang.pojo.entity.AdminDo;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.redis.RedisCache;
import com.tztang.redis.RedisKeyBuild;
import com.tztang.service.TokenService;
import com.tztang.util.AdminTokenHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TokenServiceImpl extends TokenService<AdminDo> {

    @Resource
    private RedisCache redisCache;
    @Resource
    private AdminTokenHelper tokenHelper;

    @Override
    public boolean verifyToken(String newToken) {
        String account = tokenHelper.getAccount(newToken);
        String oldToken = redisCache.getForHash(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, account), "token", String.class);
        return !newToken.equals(oldToken);
    }

    @Override
    public String createToken(AdminDo adminDo) {
        return tokenHelper.createToken(adminDo);
    }

    public String getId(String token) {
        return tokenHelper.getId(token);
    }

    @Override
    public String getBaseInfo(String token)  {
        String account = tokenHelper.getAccount(token);
        return redisCache.get(RedisKeyBuild.createRedisKey(RedisKeyManage.ADMIN_LOGIN, account), String.class);
    }

}
