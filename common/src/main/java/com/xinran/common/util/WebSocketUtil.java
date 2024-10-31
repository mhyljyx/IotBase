package com.xinran.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.Session;

/**
 * @author xuehy
 * @since 2023/1/4
 */
@Slf4j
public class WebSocketUtil {

    //使用WebSocket向客户端发送消息
    public static Result sendMessage(Session session, Result result) {
        return sendMessage(session, JSONObject.toJSONString(result));
    }
    public static Result sendMessage(Session session, String message) {
        //默认同步发送
        return sendMessage(session, message, false);
    }

    /**
     * 使用WebSocket向客户端发送消息
     * @param session   {@link Session}
     * @param message   消息
     * @param async     是否异步发送
     * @return  是否发送成功
     */
    public static Result sendMessage(Session session, String message, boolean async) {
        if (ObjectUtil.isNotNull(session) && session.isOpen()) {
            try {
                if (async) {
                    session.getAsyncRemote().sendText(message);
                } else {
                    session.getBasicRemote().sendText(message);
                }
                return Result.success();
            } catch (Exception e) {
                log.error("WebSocket消息发送失败:", e);
                return Result.fail(e.getMessage());
            }
        } else {
            log.error("WebSocket消息发送失败:Session[{}]不存在", session.getId());
        }
        return Result.fail("WebSocket消息发送失败:Session[{}]不存在", session.getId());
    }

}
