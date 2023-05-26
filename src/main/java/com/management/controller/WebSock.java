package com.management.controller;


import com.management.model.request.UserModelRequest;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/chat/{username}")
public class WebSock {

    private Session session;
    private static Set<WebSock> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(
            Session session,
            @PathParam("username") String username) throws IOException {
        System.out.println("connected to websocket" );
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

//        Message message = new Message();
//        message.setFrom(username);
//        message.setContent("Connected!");
//        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, String message)
            throws IOException, EncodeException {

        broadcast(message);
    }

  //  @OnClose
    public void onClose(Session session) throws IOException {

        chatEndpoints.remove(this);

        //broadcast();
    }

    //@OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(String message)
            throws IOException, EncodeException {

        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().
                            sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
