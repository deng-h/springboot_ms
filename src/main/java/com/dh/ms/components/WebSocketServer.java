package com.dh.ms.components;

import com.dh.ms.vo.ResultVO;
import com.dh.ms.websocket.ServerEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Slf4j
//类似于controller
@ServerEndpoint(value = "/ws", encoders = {ServerEncoder.class})
@Component
public class WebSocketServer {

    private static Session session;  //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private static boolean isOpen = false;
    private static int showTimes = 3; // 当WebSocket未连接时，log一直输出提示信息会污染控制台，所以设置输出次数

    //连接建立成功时调用的方法
    @OnOpen
    public void onOpen(Session s){
        log.info("WebSocket连接成功！");
        session = s;
        isOpen = true;
    }

    //连接关闭调用的方法
    @OnClose
    public void onClose(Session session){
        log.info("WebSocket断开连接！");
        isOpen = false;
    }

    //收到客户端消息后调用的方法
    @OnMessage
    public void onMessage(String msg, Session session){

    }

    @OnError
    public void onError(Session session, Throwable error){

    }

    //服务器给客户端发消息
    public static void sendMessage(ResultVO res){
        try{
            if(isOpen){
                session.getBasicRemote().sendObject(res);
            }else{
                if(showTimes > 0){
                    showTimes -= 1;
                    log.error("WebSocket未连接...");
                }
            }
        }catch (IOException | EncodeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
