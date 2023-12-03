package id.zakariaandy.websocket.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import id.zakariaandy.websocket.handler.WebSocketSessionHolder;
import id.zakariaandy.websocket.model.OrderResultDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@RestController
public class OrderController {

    @PostMapping(path = "/updateorder")
    public String updateOrder(@RequestBody OrderResultDTO orderResultDTO) throws IOException {
        WebSocketSession webSocketSession = WebSocketSessionHolder.getSessions()
                .stream()
                .filter(session -> {
                    String orderId = (String) session.getAttributes().get("orderId");
                    System.out.println(orderId);
                    System.out.println(orderResultDTO.getOrderId());
                    return orderId.equals(orderResultDTO.getOrderId());
                }).findFirst().get();

        ObjectMapper objectMapper = new ObjectMapper();
        webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString("Your order result is " + orderResultDTO.getOrderStatus())));
        return "ok";
    }

}
