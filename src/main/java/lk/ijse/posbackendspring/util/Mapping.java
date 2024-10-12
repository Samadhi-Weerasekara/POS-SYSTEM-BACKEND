package lk.ijse.posbackendspring.util;


import lk.ijse.posbackendspring.dto.CustomerDTO;
import lk.ijse.posbackendspring.dto.ItemDTO;
import lk.ijse.posbackendspring.entity.CustomerEntity;
import lk.ijse.posbackendspring.entity.ItemEntity;
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
    public CustomerEntity convertToEntity(CustomerDTO dto) {
        return modelMapper.map(dto, CustomerEntity.class);
    }
    public List<CustomerDTO> convertToDTO(List<CustomerEntity> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
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


}
