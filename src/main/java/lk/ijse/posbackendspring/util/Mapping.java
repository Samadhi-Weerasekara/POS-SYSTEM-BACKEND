package lk.ijse.posbackendspring.util;


import lk.ijse.posbackendspring.customObj.CustomerResponse;
import lk.ijse.posbackendspring.dto.CustomerDTO;
import lk.ijse.posbackendspring.dto.ItemDTO;
import lk.ijse.posbackendspring.dto.OrderDTO;
import lk.ijse.posbackendspring.dto.OrderDetailsDTO;
import lk.ijse.posbackendspring.entity.CustomerEntity;
import lk.ijse.posbackendspring.entity.ItemEntity;
import lk.ijse.posbackendspring.entity.OrderDetailEntity;
import lk.ijse.posbackendspring.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    //matters of customer Entity and customer DTO
    public CustomerDTO convertToDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    //item matters mapping

    public ItemDTO convertToDTO(ItemEntity item) {
        return modelMapper.map(item, ItemDTO.class);
    }
    public ItemEntity convertToEntity(ItemDTO dto) {
        return modelMapper.map(dto, ItemEntity.class);
    }
    public List<ItemDTO> convertItemToDTOList(List<ItemEntity> items) {
        return modelMapper.map(items, new TypeToken<List<ItemDTO>>() {}.getType());
    }


    public CustomerEntity convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> convertCustomerEntityListToCustomerDTOList(List<CustomerEntity> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());

    }
    public OrderDTO convertOrderEntityToOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public OrderEntity convertOrderDTOToOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public OrderDetailsDTO convertOrderDetailsEntityToOrderDetailsDTO(OrderDetailEntity orderDetailsEntity) {
        return modelMapper.map(orderDetailsEntity, OrderDetailsDTO.class);
    }

    public OrderDetailEntity convertOrderDetailsDTOToOrderDetailsEntity(OrderDetailsDTO orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailEntity.class);
    }

    public List<OrderDetailsDTO> convertOrderDetailEntityListToOrderDetailDTOList(List<OrderDetailEntity> orderDetailsEntityList) {
        return modelMapper.map(orderDetailsEntityList, new TypeToken<List<OrderDetailsDTO>>() {}.getType());
    }

}
