package lk.ijse.posbackendspring.service;

import lk.ijse.posbackendspring.dto.OrderDTO;
import lk.ijse.posbackendspring.dto.OrderDetailsDTO;

import java.util.List;

public interface PlaceOrderService {
    void saveOrder(OrderDTO orderDTO);

    List<OrderDetailsDTO> getOrderDetails();
}
