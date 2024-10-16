package lk.ijse.posbackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendspring.dao.OrderDao;
import lk.ijse.posbackendspring.dao.OrderDetailsDao;
import lk.ijse.posbackendspring.dto.OrderDTO;
import lk.ijse.posbackendspring.dto.OrderDetailsDTO;
import lk.ijse.posbackendspring.entity.OrderDetailEntity;
import lk.ijse.posbackendspring.entity.OrderEntity;
import lk.ijse.posbackendspring.exception.DataPersistFailedException;
import lk.ijse.posbackendspring.util.AppUtil;
import lk.ijse.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {
    @Autowired
    private OrderDao orderDAO;

    @Autowired
    private OrderDetailsDao orderDetailsDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        // Create the OrderEntity
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(AppUtil.createOrderId());
        orderEntity.setOrderDate(LocalDateTime.now());
        orderEntity.setTotalPrice(orderDTO.getTotalPrice());
        orderEntity.setCustomerId(orderDTO.getCustomerId());

        // Save the OrderEntity
        OrderEntity savedOrder = orderDAO.save(orderEntity);

        List<OrderDetailsDTO> orderDetailsDTOS = orderDTO.getOrderDetailsDTOList();

        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS) {
            OrderDetailEntity orderDetailsEntity = new OrderDetailEntity();

            // Set the orderId in the OrderDetailEntity
            orderDetailsEntity.setOrderId(savedOrder.getOrderId()); // Ensure this is set

            orderDetailsEntity.setItemId(orderDetailsDTO.getItemCode());
            orderDetailsEntity.setItemName(orderDetailsDTO.getItemName());
            orderDetailsEntity.setQty(orderDetailsDTO.getQty());
            orderDetailsEntity.setUnitPrice(orderDetailsDTO.getUnitPrice());
            orderDetailsEntity.setTotal(orderDetailsDTO.getTotal());

            orderDetailsDAO.save(orderDetailsEntity); // Save the OrderDetailEntity
        }

        // Check if order saving was successful
        if (savedOrder == null) {
            throw new DataPersistFailedException("Order save failed");
        }
    }



    @Override
    public List<OrderDetailsDTO> getOrderDetails() {
        return mapping.convertOrderDetailEntityListToOrderDetailDTOList(orderDetailsDAO.findAll());
}
    }
