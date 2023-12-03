package id.zakariaandy.websocket.handler;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.WebSocketSessionDecorator;

import java.net.URI;
import java.util.Arrays;

public class OrderResultHandler implements WebSocketHandler {
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println(webSocketSession.getUri());
        String orderId = Arrays.stream(webSocketSession.getUri().getQuery().split("&"))
                .filter(param -> param.contains("orderId"))
                .map(param -> {
                    return param.split("=")[1];
                })
                .findFirst()
                .get();

        webSocketSession.getAttributes().put("orderId", orderId);
        WebSocketSessionHolder.addSession(webSocketSession);
        System.out.println("Connection established, with session id:" + webSocketSession.getId());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        // do nothing
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        WebSocketSessionHolder.removeSession(webSocketSession);
        System.out.println("Connection closed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
