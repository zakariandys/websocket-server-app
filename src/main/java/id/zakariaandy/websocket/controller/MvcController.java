package id.zakariaandy.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MvcController {

    @GetMapping(path = "/order.htm")
    public String indexPage(@RequestParam(name = "orderId") String orderId, Model model) {
        model.addAttribute(orderId);
        return "order.html";
    }
}
