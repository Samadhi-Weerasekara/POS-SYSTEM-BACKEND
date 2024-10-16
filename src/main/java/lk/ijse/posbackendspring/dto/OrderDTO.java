package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.OrderResponse;
import lk.ijse.posbackendspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderResponse {
    private String orderId;
    private LocalDateTime orderDate;
    private String customerId;
    private double totalPrice;
    private List<OrderDetailsDTO> orderDetailsDTOList;



}
