package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.OrderDetailResponse;
import lk.ijse.posbackendspring.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements SuperDTO, OrderDetailResponse {
    private String itemId;
    private String orderId;
    private String itemName;
    private int qty;
    private double unitPrice;
    private double total;

}
