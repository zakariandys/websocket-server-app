package id.zakariaandy.websocket.model;

import java.io.Serializable;

public class OrderResultDTO implements Serializable {

    private String orderId;

    private String orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderResultDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
