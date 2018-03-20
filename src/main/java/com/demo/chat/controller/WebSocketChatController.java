package com.demo.chat.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/2/23 14:04
 */

@Component
@ServerEndpoint("/wchat")
public class WebSocketChatController {
    private static Logger logger= LoggerFactory.getLogger(WebSocketChatController.class);
    public static Map<String,WebSocketChatController> sessionList= new ConcurrentHashMap<String,WebSocketChatController>();
    public Session  session ;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        System.out.println("用户"+session.getId()+"链接");
        this.session = session;
        sessionList.put(session.getId(),this);
//        sendMessage("链接成功");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("接受信息:"+message);
        for (Map.Entry<String,WebSocketChatController> entry: sessionList.entrySet()) {
            if(!this.equals(entry.getValue())) {
                sendMessage(entry.getValue().getSession(), message);
            }
        }
    }

    @OnError
    public void onError(Throwable t) throws IOException {
        System.err.println("出错了");
        logger.error("s:",t);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException {
        sessionList.remove(session.getId());
        System.out.println(session.getId()+"退出链接");
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    public void sendMessage(Session  session, String message) throws IOException {
        JSONObject json = new JSONObject();
        json.put("msg",message);
        json.put("auth",session.getId());
        session.getBasicRemote().sendText(json.toJSONString());
        //this.session.getAsyncRemote().sendText(message);
    }

    public Session getSession() {
        return session;
    }
}
