package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.OrderResponse;
import lk.ijse.posbackendspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String orderId;
    private String orderDate;
    private String customerId;
    private double total;
    private List<OrderDetailsDTO> orderDetailsDTOList;



}
