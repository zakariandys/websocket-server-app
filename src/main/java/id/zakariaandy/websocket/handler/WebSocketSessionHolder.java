package id.zakariaandy.websocket.handler;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

public class WebSocketSessionHolder {
    private static Set<WebSocketSession> WEB_SOCKET_SESSIONS = new HashSet<>();

    public static void addSession(WebSocketSession session) {
        WEB_SOCKET_SESSIONS.add(session);
    }

    public static Set<WebSocketSession> getSessions() {
        System.out.println(WEB_SOCKET_SESSIONS);
        return WEB_SOCKET_SESSIONS;
    }

    public static void removeSession(WebSocketSession session) {
        WEB_SOCKET_SESSIONS.remove(session);
    }
}
