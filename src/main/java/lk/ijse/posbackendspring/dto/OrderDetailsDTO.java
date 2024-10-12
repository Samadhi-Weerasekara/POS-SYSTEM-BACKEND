package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.OrderDetailResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO implements SuperDTO, OrderDetailResponse {
    private String itemCode;
    private String itemName;
    private int qty;
    private double unitPrice;
    private double total;

}
