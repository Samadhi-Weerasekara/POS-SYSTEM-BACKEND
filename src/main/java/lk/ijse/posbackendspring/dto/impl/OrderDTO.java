package lk.ijse.posbackendspring.dto.impl;

import lk.ijse.posbackendspring.customObj.OrderResponse;
import lk.ijse.posbackendspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String orderId;
    private String orderDate;
    private String customerId;
    private String itemId;
    private int orderQty;
    private double discount;
    private int cash;

}
